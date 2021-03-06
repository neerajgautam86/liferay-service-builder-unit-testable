package com.liferay.devcon2013.service.impl;

import java.util.Date;

import com.liferay.devcon2013.model.BeerDrinker;
import com.liferay.devcon2013.service.base.BeerDrinkerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the beer drinker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.devcon2013.service.BeerDrinkerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.devcon2013.service.base.BeerDrinkerLocalServiceBaseImpl
 * @see com.liferay.devcon2013.service.BeerDrinkerLocalServiceUtil
 */
public class BeerDrinkerLocalServiceImpl extends BeerDrinkerLocalServiceBaseImpl {

	public BeerDrinker addBeerDrinker(
		String name, float alcoholLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(name, alcoholLevel);

		User user = userLocalService.getUser(serviceContext.getUserId());
		long beerDrinkerId = counterLocalService.increment(BeerDrinker.class.getName());
		BeerDrinker beerDrinker = beerDrinkerPersistence.create(beerDrinkerId);

		beerDrinker.setCompanyId(serviceContext.getCompanyId());
		beerDrinker.setGroupId(serviceContext.getScopeGroupId());
		beerDrinker.setUserId(user.getUserId());
		beerDrinker.setUserName(user.getFullName());
		beerDrinker.setName(name);
		beerDrinker.setAlcoholLevel(alcoholLevel);

		beerDrinker.setStatus(WorkflowConstants.STATUS_DRAFT);
		beerDrinker.setStatusByUserId(user.getUserId());
		beerDrinker.setStatusDate(new Date());

		beerDrinkerPersistence.update(beerDrinker);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			beerDrinker.getCompanyId(), beerDrinker.getGroupId(),
			beerDrinker.getUserId(), BeerDrinker.class.getName(),
			beerDrinker.getPrimaryKey(), beerDrinker, serviceContext);

		return beerDrinker;
	}

	protected void validate(String name, float alcoholLevel) {
		if (Validator.isNull(name)) {
			throw new IllegalArgumentException(
				"Parameter name cannot be null or empty!");
		}

		if (alcoholLevel < 0) {
			throw new IllegalArgumentException(
				"Parameter alcoholLevel cannot be negative!");
		}
	}
}
