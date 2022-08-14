/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Restapi [restful]<br>
 * USAGE:
 * <pre>
 *        NewClient client = new NewClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vpraj
 */
public class NewClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/StudyStuff_1/webresources";

    public NewClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("restful");
    }

    public <T> T getProductDataByCategoryId(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductDataByCategoryId/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getProductData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addProduct(String productName, String productDesc, String product_img, String price, String categoryId, String inventoryId, String discountId) throws ClientErrorException {
       System.out.println("client:"+productName+productDesc+product_img+price+categoryId+inventoryId+discountId);
      
        return webTarget.path(java.text.MessageFormat.format("addProduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{productName, productDesc, product_img, price, categoryId, inventoryId, discountId})).request().post(null, String.class);
    }


    public String updateProduct(String productId, String productName, String productDesc, String product_img, String price, String categoryId, String inventoryId, String discountId) throws ClientErrorException {
        System.out.println("client:"+productName+productDesc+product_img+price+categoryId+inventoryId+discountId);
      
        return webTarget.path(java.text.MessageFormat.format("updateProduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{productId, productName, productDesc, product_img, price, categoryId, inventoryId, discountId})).request().post(null, String.class);
    }

    public <T> T getDiscountById(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getDiscountById");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String deleteDiscount(String discountId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteDiscount/{0}", new Object[]{discountId})).request().delete(String.class);
    }

    public String updateCategory(String categoryId, String categoryName, String categoryDesc) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}/{2}", new Object[]{categoryId, categoryName, categoryDesc})).request().post(null, String.class);
    }

    public <T> T getCategoryName(Class<T> responseType, String categoryName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryName/{0}", new Object[]{categoryName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addInventory(String qty) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("addInventory/{0}", new Object[]{qty}));
        return webTarget.path(java.text.MessageFormat.format("addInventory/{0}", new Object[]{qty})).request().post(null, String.class);
       }

    public String updateDiscount(String discountId, String discountName, String discountDesc, String active,String percent) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateDiscount/{0}/{1}/{2}/{3}/{4}", new Object[]{discountId, discountName, discountDesc, active,percent})).request().post(null, String.class);
    }

    public String deleteCategory(String categoryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCategory/{0}", new Object[]{categoryId})).request().delete(String.class);
    }

    public <T> T getDiscountData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getDiscountData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductById(Class<T> responseType, String productId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductById/{0}", new Object[]{productId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getDiscountByName(Class<T> responseType, String discountName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDiscountByName/{0}", new Object[]{discountName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addCategory(String categoryName, String categoryDesc) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addCategory/{0}/{1}", new Object[]{categoryName, categoryDesc})).request().post(null, String.class);
    }

    public <T> T getInventoryById(Class<T> responseType, String inventoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getInventoryById/{0}", new Object[]{inventoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCategoryById(Class<T> responseType, String categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryById/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addDiscount(String discountName, String discountDesc, String active,String percent) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addDiscount/{0}/{1}/{2}/{3}", new Object[]{discountName, discountDesc, active,percent})).request().post(null, String.class);
    }

    public <T> T getCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getCategories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductByName(Class<T> responseType, String productName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductByName/{0}", new Object[]{productName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String updateInventory(String inventoryId, String qty) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateInventory/{0}/{1}", new Object[]{inventoryId, qty})).request().post(null, String.class);
    }

    public <T> T getInventoryData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getInventoryData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String deleteProduct(String productId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteProduct/{0}", new Object[]{productId})).request().delete(String.class);
    }

    public String deleteInventory(String inventoryId) throws ClientErrorException {
      
        return webTarget.path(java.text.MessageFormat.format("deleteInventory/{0}", new Object[]{inventoryId})).request().delete(String.class);
    }
    
    //user
     public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
     public String addUser(String userName, String password, String email, String firstName, String lastName, String mobile, String user_img) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{userName, password, email, firstName, lastName, mobile, user_img})).request().post(null, String.class);
    }
     public String updateUser(String userId, String userName, String password, String email, String firstName, String lastName, String mobile, String user_img) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateUser//{0}{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{userId, userName, password, email, firstName, lastName, mobile, user_img})).request().post(null, String.class);
    }
      public String deleteUser(String userId ) throws ClientErrorException {
         return webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{userId})).request().delete(String.class);
    }
      public <T> T getUserById(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getUserById");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }


    public void close() {
        client.close();
    }
    
}
