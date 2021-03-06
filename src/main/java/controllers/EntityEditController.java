package controllers;

import ejb.AdminEJB;
import ejb.CustomerEJB;
import ejb.ServiceCategoryEJB;
import ejb.ServiceEJB;
import ejb.ServiceOrderEJB;
import ejb.StaffEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import entities.Admin;
import entities.Customer;
import entities.Service;
import entities.ServiceCategory;
import entities.ServiceOrder;
import entities.Staff;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * EntityEditController:
 * A requestScoped controller to handle edit functionalities of entities
 */
@Named(value = "entityEditController")
@RequestScoped
public class EntityEditController implements Serializable {

    /**
     * Default constructor
     */
    public EntityEditController() {
    }

    //EJB injections
    @EJB
    private AdminEJB adminEJB;
    @EJB
    private CustomerEJB customerEJB;
    @EJB
    private StaffEJB staffEJB;
    @EJB
    private ServiceEJB serviceEJB;
    @EJB
    private ServiceCategoryEJB serviceCategoryEJB;
    @EJB
    private ServiceOrderEJB serviceOrderEJB;

    private static Admin admin = new Admin();
    private static Customer customer = new Customer();
    private static Staff staff = new Staff();
    private static Service service = new Service();
    private static ServiceCategory serviceCategory = new ServiceCategory();
    private static ServiceOrder serviceOrder = new ServiceOrder();

    /**
     * Function to get the required entity to be edited 
     * @param id to be passed to find the entity 
     * @param entityName to be passed to switch the cases
     * @return string: name of the page to rendered next
     */
    public String doEditEntity(Long id, String entityName) {
        switch (entityName.toLowerCase()) {
            case "admin":
                admin = adminEJB.getAdmin(id);
                return "editAdmin.xhtml?faces-redirect=true";
            case "customer":
                customer = customerEJB.getCustomer(id);
                return "editCustomer.xhtml?faces-redirect=true";
            case "staff":
                staff = staffEJB.getStaff(id);
                return "editStaff.xhtml?faces-redirect=true";
            case "service":
                service = serviceEJB.getService(id);
                return "editService.xhtml?faces-redirect=true";
            case "servicecategory":
                serviceCategory = serviceCategoryEJB.getServiceCategory(id);
                return "editServiceCategory.xhtml?faces-redirect=true";
            default:
                return null;
        }
    }

    /**
     * Function to carry out the edit operation of the entity
     * @param entityName to be passed to the switch case
     * @return string: name of the page to be rendered
     */
    public String doEditEntityCommit(String entityName) {
        switch (entityName.toLowerCase()) {
            case "admin":

                if (adminEJB.editAdminCommit(admin) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "listAdmins.xhtml?faces-redirect=true";
                }
            case "customer":

                if (customerEJB.editCustomerCommit(customer) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "customer Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "listCustomers.xhtml?faces-redirect=true";
                }
            case "staff":

                if (staffEJB.editStaffCommit(staff) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Staff Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "listStaffs.xhtml?faces-redirect=true";
                }
            case "service":

                if (serviceEJB.editServiceCommit(service) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Service Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "listService.xhtml?faces-redirect=true";
                }
            case "servicecategory":

                if (serviceCategoryEJB.editServiceCategoryCommit(serviceCategory) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Service Category Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "listServiceCategory.xhtml?faces-redirect=true";
                }
            default:
                return null;
        }
    }

    /**
     * Function to perform cancellation of edit operation on entity
     * @param entityName to be passed to switch case
     * @return string: name of the page to be rendered
     */
    public String doCancelEdit(String entityName) {
        

        switch (entityName.toLowerCase()) {
            case "admin":
                return "listAdmins.xhtml?faces-redirect=true";
            case "customer":
                return "listCustomers.xhtml?faces-redirect=true";
            case "staff":
                return "listStaffs.xhtml?faces-redirect=true";
            case "service":
                return "listService.xhtml?faces-redirect=true";
            case "servicecategory":
                return "listServiceCategory.xhtml?faces-redirect=true";
            case "serviceorder":
                return "listServiceOrders.xhtml?faces-redirect=true";
            case "ratefeedback":
                return "customerMyOrders.xhtml?faces-redirect=true";
            default:
                return null;
        }

    }

    /**
     * Function to show the details of the entity
     * @param id to be passed to find the entity from the database
     * @param entityName to be passed to the switch case
     * @return string: name of the page to be rendered
     */
    public String doVeiwDetails(Long id, String entityName) {

        switch (entityName.toLowerCase()) {
            case "admin":
                admin = adminEJB.getAdmin(id);
                return "viewAdmin.xhtml?faces-redirect=true";
            case "customer":
                customer = customerEJB.getCustomer(id);
                return "viewCustomer.xhtml?faces-redirect=true";
            case "staff":
                staff = staffEJB.getStaff(id);
                return "viewStaff.xhtml?faces-redirect=true";
            case "service":
                service = serviceEJB.getService(id);
                return "viewService.xhtml?faces-redirect=true";
            case "servicecategory":
                serviceCategory = serviceCategoryEJB.getServiceCategory(id);
                return "viewServiceCategory.xhtml?faces-redirect=true";
            case "serviceorder":
                serviceOrder = serviceOrderEJB.getServiceOrder(id);
                return "viewServiceOrder.xhtml?faces-redirect=true";
            default:
                return null;
        }
    }

    /**
     * Function to perform edit operation of the customer from the frontend
     * @param entityName to be passed to switch case
     * @return string: name of the page to be rendered
     */
    public String frontendDoEditEntityCommit(String entityName) {
        switch (entityName.toLowerCase()) {

            case "customer":

                if (customerEJB.editCustomerCommit(customer) >= 0) {
                    FacesMessage infoMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "customer Edited", "");
                    FacesContext.getCurrentInstance().addMessage(null, infoMsg);
                    return "customerMyAccount.xhtml?faces-redirect=true";
                }

            default:
                return null;
        }
    }

    /**
     * Function to view details of entity from the frontend
     * @param id to be passed to find the entity 
     * @param entityName to be passed to the switch case
     * @return string: name of the page to be rendered
     */
    public String frontendDoVeiwDetails(Long id, String entityName) {

        switch (entityName.toLowerCase()) {
            case "serviceorder":
                serviceOrder = serviceOrderEJB.getServiceOrder(id);
                return "frontendViewServiceOrder.xhtml?faces-redirect=true";
            default:
                return null;
        }
    }

    /**
     * Function to perform edit cancellation from frontend
     * @param entityName to be passed to the switch case
     * @return string: name of the page to be rendered
     */
    public String frontendDoCancelEdit(String entityName) {
        //return "listServiceOrders.xhtml?faces-redirect=true";

        switch (entityName.toLowerCase()) {
            case "serviceorder":
                return "customerMyOrders.xhtml?faces-redirect=true";
            default:
                return null;
        }

    }

    /**
     *
     * @return an admin object
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin to set the attribute admin
     */
    public void setAdmin(Admin admin) {
        EntityEditController.admin = admin;
    }

    /**
     *
     * @return a customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer to set the attribute customer
     */
    public void setCustomer(Customer customer) {
        EntityEditController.customer = customer;
    }

    /**
     *
     * @return a staff object
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff to set the attribute staff
     */
    public void setStaff(Staff staff) {
        EntityEditController.staff = staff;
    }

    /**
     *
     * @return a service object
     */
    public Service getService() {
        return service;
    }

    /**
     *
     * @param service to set the attribute service
     */
    public void setService(Service service) {
        EntityEditController.service = service;
    }

    /**
     *
     * @return a service category object
     */
    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    /**
     *
     * @param serviceCategory to set the attribute serviceCategory
     */
    public void setServiceCategory(ServiceCategory serviceCategory) {
        EntityEditController.serviceCategory = serviceCategory;
    }

    /**
     *
     * @return a serviceOrder object
     */
    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    /**
     *
     * @param serviceOrder to set the attribute serviceOrder
     */
    public void setServiceOrder(ServiceOrder serviceOrder) {
        EntityEditController.serviceOrder = serviceOrder;
    }

}
