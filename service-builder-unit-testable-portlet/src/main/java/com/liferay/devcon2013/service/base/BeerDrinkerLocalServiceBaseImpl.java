package com.liferay.devcon2013.service.base;

import com.liferay.devcon2013.model.BeerDrinker;
import com.liferay.devcon2013.service.BeerDrinkerLocalService;
import com.liferay.devcon2013.service.persistence.BeerDrinkerPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the beer drinker local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.devcon2013.service.impl.BeerDrinkerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.devcon2013.service.impl.BeerDrinkerLocalServiceImpl
 * @see com.liferay.devcon2013.service.BeerDrinkerLocalServiceUtil
 * @generated
 */
public abstract class BeerDrinkerLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements BeerDrinkerLocalService,
        IdentifiableBean {
    @BeanReference(type = com.liferay.devcon2013.service.BeerDrinkerLocalService.class)
    protected com.liferay.devcon2013.service.BeerDrinkerLocalService beerDrinkerLocalService;
    @BeanReference(type = com.liferay.devcon2013.service.BeerDrinkerService.class)
    protected com.liferay.devcon2013.service.BeerDrinkerService beerDrinkerService;
    @BeanReference(type = BeerDrinkerPersistence.class)
    protected BeerDrinkerPersistence beerDrinkerPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portal.service.WorkflowInstanceLinkLocalService.class)
    protected com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
    @BeanReference(type = WorkflowInstanceLinkPersistence.class)
    protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private BeerDrinkerLocalServiceClpInvoker _clpInvoker = new BeerDrinkerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.devcon2013.service.BeerDrinkerLocalServiceUtil} to access the beer drinker local service.
     */

    /**
     * Adds the beer drinker to the database. Also notifies the appropriate model listeners.
     *
     * @param beerDrinker the beer drinker
     * @return the beer drinker that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public BeerDrinker addBeerDrinker(BeerDrinker beerDrinker)
        throws SystemException {
        beerDrinker.setNew(true);

        return beerDrinkerPersistence.update(beerDrinker);
    }

    /**
     * Creates a new beer drinker with the primary key. Does not add the beer drinker to the database.
     *
     * @param beerDrinkerId the primary key for the new beer drinker
     * @return the new beer drinker
     */
    @Override
    public BeerDrinker createBeerDrinker(long beerDrinkerId) {
        return beerDrinkerPersistence.create(beerDrinkerId);
    }

    /**
     * Deletes the beer drinker with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param beerDrinkerId the primary key of the beer drinker
     * @return the beer drinker that was removed
     * @throws PortalException if a beer drinker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public BeerDrinker deleteBeerDrinker(long beerDrinkerId)
        throws PortalException, SystemException {
        return beerDrinkerPersistence.remove(beerDrinkerId);
    }

    /**
     * Deletes the beer drinker from the database. Also notifies the appropriate model listeners.
     *
     * @param beerDrinker the beer drinker
     * @return the beer drinker that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public BeerDrinker deleteBeerDrinker(BeerDrinker beerDrinker)
        throws SystemException {
        return beerDrinkerPersistence.remove(beerDrinker);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(BeerDrinker.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return beerDrinkerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.devcon2013.model.impl.BeerDrinkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return beerDrinkerPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.devcon2013.model.impl.BeerDrinkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return beerDrinkerPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return beerDrinkerPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return beerDrinkerPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public BeerDrinker fetchBeerDrinker(long beerDrinkerId)
        throws SystemException {
        return beerDrinkerPersistence.fetchByPrimaryKey(beerDrinkerId);
    }

    /**
     * Returns the beer drinker with the matching UUID and company.
     *
     * @param uuid the beer drinker's UUID
     * @param  companyId the primary key of the company
     * @return the matching beer drinker, or <code>null</code> if a matching beer drinker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BeerDrinker fetchBeerDrinkerByUuidAndCompanyId(String uuid,
        long companyId) throws SystemException {
        return beerDrinkerPersistence.fetchByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the beer drinker matching the UUID and group.
     *
     * @param uuid the beer drinker's UUID
     * @param groupId the primary key of the group
     * @return the matching beer drinker, or <code>null</code> if a matching beer drinker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BeerDrinker fetchBeerDrinkerByUuidAndGroupId(String uuid,
        long groupId) throws SystemException {
        return beerDrinkerPersistence.fetchByUUID_G(uuid, groupId);
    }

    /**
     * Returns the beer drinker with the primary key.
     *
     * @param beerDrinkerId the primary key of the beer drinker
     * @return the beer drinker
     * @throws PortalException if a beer drinker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BeerDrinker getBeerDrinker(long beerDrinkerId)
        throws PortalException, SystemException {
        return beerDrinkerPersistence.findByPrimaryKey(beerDrinkerId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return beerDrinkerPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the beer drinker with the matching UUID and company.
     *
     * @param uuid the beer drinker's UUID
     * @param  companyId the primary key of the company
     * @return the matching beer drinker
     * @throws PortalException if a matching beer drinker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BeerDrinker getBeerDrinkerByUuidAndCompanyId(String uuid,
        long companyId) throws PortalException, SystemException {
        return beerDrinkerPersistence.findByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the beer drinker matching the UUID and group.
     *
     * @param uuid the beer drinker's UUID
     * @param groupId the primary key of the group
     * @return the matching beer drinker
     * @throws PortalException if a matching beer drinker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BeerDrinker getBeerDrinkerByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return beerDrinkerPersistence.findByUUID_G(uuid, groupId);
    }

    /**
     * Returns a range of all the beer drinkers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.devcon2013.model.impl.BeerDrinkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of beer drinkers
     * @param end the upper bound of the range of beer drinkers (not inclusive)
     * @return the range of beer drinkers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BeerDrinker> getBeerDrinkers(int start, int end)
        throws SystemException {
        return beerDrinkerPersistence.findAll(start, end);
    }

    /**
     * Returns the number of beer drinkers.
     *
     * @return the number of beer drinkers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getBeerDrinkersCount() throws SystemException {
        return beerDrinkerPersistence.countAll();
    }

    /**
     * Updates the beer drinker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param beerDrinker the beer drinker
     * @return the beer drinker that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public BeerDrinker updateBeerDrinker(BeerDrinker beerDrinker)
        throws SystemException {
        return beerDrinkerPersistence.update(beerDrinker);
    }

    /**
     * Returns the beer drinker local service.
     *
     * @return the beer drinker local service
     */
    public com.liferay.devcon2013.service.BeerDrinkerLocalService getBeerDrinkerLocalService() {
        return beerDrinkerLocalService;
    }

    /**
     * Sets the beer drinker local service.
     *
     * @param beerDrinkerLocalService the beer drinker local service
     */
    public void setBeerDrinkerLocalService(
        com.liferay.devcon2013.service.BeerDrinkerLocalService beerDrinkerLocalService) {
        this.beerDrinkerLocalService = beerDrinkerLocalService;
    }

    /**
     * Returns the beer drinker remote service.
     *
     * @return the beer drinker remote service
     */
    public com.liferay.devcon2013.service.BeerDrinkerService getBeerDrinkerService() {
        return beerDrinkerService;
    }

    /**
     * Sets the beer drinker remote service.
     *
     * @param beerDrinkerService the beer drinker remote service
     */
    public void setBeerDrinkerService(
        com.liferay.devcon2013.service.BeerDrinkerService beerDrinkerService) {
        this.beerDrinkerService = beerDrinkerService;
    }

    /**
     * Returns the beer drinker persistence.
     *
     * @return the beer drinker persistence
     */
    public BeerDrinkerPersistence getBeerDrinkerPersistence() {
        return beerDrinkerPersistence;
    }

    /**
     * Sets the beer drinker persistence.
     *
     * @param beerDrinkerPersistence the beer drinker persistence
     */
    public void setBeerDrinkerPersistence(
        BeerDrinkerPersistence beerDrinkerPersistence) {
        this.beerDrinkerPersistence = beerDrinkerPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the workflow instance link local service.
     *
     * @return the workflow instance link local service
     */
    public com.liferay.portal.service.WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
        return workflowInstanceLinkLocalService;
    }

    /**
     * Sets the workflow instance link local service.
     *
     * @param workflowInstanceLinkLocalService the workflow instance link local service
     */
    public void setWorkflowInstanceLinkLocalService(
        com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
        this.workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
    }

    /**
     * Returns the workflow instance link persistence.
     *
     * @return the workflow instance link persistence
     */
    public WorkflowInstanceLinkPersistence getWorkflowInstanceLinkPersistence() {
        return workflowInstanceLinkPersistence;
    }

    /**
     * Sets the workflow instance link persistence.
     *
     * @param workflowInstanceLinkPersistence the workflow instance link persistence
     */
    public void setWorkflowInstanceLinkPersistence(
        WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {
        this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.liferay.devcon2013.model.BeerDrinker",
            beerDrinkerLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.liferay.devcon2013.model.BeerDrinker");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return BeerDrinker.class;
    }

    protected String getModelClassName() {
        return BeerDrinker.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = beerDrinkerPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
