/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService_rest;

import SessionBeans.studystuffBeanLocal;
import entities.Discount;
import entities.Product;
import entities.ProductCategory;
import entities.ProductInventory;
import entities.User;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vpraj
 */
@Path("restful")
public class Restapi {
     @EJB 
             private studystuffBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Restapi
     */
    public Restapi() {
    }

    /**
     * Retrieves representation of an instance of webService_rest.Restapi
     * @return an instance of java.lang.String
     */
     @Path("getProductData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
     public Collection<Product> getProductData() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return pbl.getProductData();
    }

    @Path("addProduct/{productName}/{productDesc}/{product_img}/{price}/{categoryId}/{inventoryId}/{discountId}")
    @POST
    //@Produces(MediaType.TEXT_PLAIN)
    public String addProduct(@PathParam("productName")String productName,@PathParam("productDesc") String productDesc,@PathParam("product_img") String product_img,@PathParam("price") int price,@PathParam("categoryId") int categoryId,@PathParam("inventoryId") int inventoryId,@PathParam("discountId") int discountId)
    {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try{
          System.out.println("addproduct:="+productName);
         pbl.addProduct(productName, productDesc,product_img , price, categoryId, inventoryId, discountId);
        
      }catch(Exception e){
         e.printStackTrace();
         e.getMessage();}
      
       return "inserted through api";
   
    }

   @Path("updateProduct/{productId}/{productName}/{productDesc}/{product_img}/{price}/{categoryId}/{inventoryId}/{discountId}")
    @POST
      @Produces(MediaType.TEXT_PLAIN)
  public String updateProduct(@PathParam("productId")int productId,@PathParam("productName")String productName,@PathParam("productDesc") String productDesc,@PathParam("product_img") String product_img,@PathParam("price") int price,@PathParam("categoryId") int categoryId,@PathParam("inventoryId") int inventoryId,@PathParam("discountId") int discountId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    System.out.println("restapi:"+productName+productDesc+product_img+price+categoryId+inventoryId+discountId);
//      return null;
     return   pbl.updateProduct(productId, productName, productDesc, product_img, price, categoryId, inventoryId, discountId);
    }

    @Path("deleteProduct/{productId}")
    @DELETE
   
    public String deleteProduct(@PathParam("productId")int productId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return  pbl.deleteProduct(productId);
      
    }

    @Path("getProductById/{productId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public Product getProductById(@PathParam("productId")int productId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        return pbl.getProductById(productId);
    }

    @Path("getProductByName/{productName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public Product getProductByName(@PathParam("productName") String productName) {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return pbl.getProductByName(productName);
    }

   @Path("getProductDataByCategoryId/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Collection<Product> getProductDataByCategoryId(@PathParam("productName") int cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return pbl.getProductDataByCategoryId(cid);
    }

     @Path("getCategories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProductCategory> getCategories() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return pbl.getCategories();
    }

    
    @Path("addCategory/{categoryName}/{categoryDesc}")
    @POST
   
    public String addCategory(@PathParam("categoryName")String categoryName,@PathParam("categoryDesc") String categoryDesc) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
   
    pbl.addCategory(categoryName, categoryDesc);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "inserted through api";
    }

   @Path("updateCategory/{categoryId}/{categoryName}/{categoryDesc}")
    @POST
   
    public String updateCategory(@PathParam("categoryId")int categoryId,@PathParam("categoryName") String categoryName,@PathParam("categoryDesc") String categoryDesc) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
       
    pbl.updateCategory(categoryId, categoryName, categoryDesc);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "updated through api";
    }

     @Path("deleteCategory/{categoryId}")
    @DELETE
    public String deleteCategory(@PathParam("categoryId")int categoryId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
    
           pbl.deleteCategory(categoryId);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "deleted through api";
    }
    @Path("getCategoryById/{categoryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public ProductCategory getCategoryById(@PathParam("categoryId")int categoryId) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return pbl.getCategoryById(categoryId);
    }

    @Path("getCategoryName/{categoryName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public ProductCategory getCategoryName(@PathParam("categoryName")String categoryName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return pbl.getCategoryName(categoryName);
             }

     @Path("getInventoryData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public Collection<ProductInventory> getInventoryData() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return pbl.getInventoryData();
    }

     @Path("addInventory/{qty}")
    @POST
    public String addInventory(@PathParam("qty")int qty) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
       pbl.addInventory(qty);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "insert api";
    }

      @Path("updateInventory/{inventoryId}/{qty}")
    @POST
    public String updateInventory(@PathParam("inventoryId")int inventoryId,@PathParam("qty") int qty) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
          pbl.updateInventory(inventoryId, qty);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated api";
    }

     @Path("deleteInventory/{inventoryId}")
    @DELETE
    public String deleteInventory(@PathParam("inventoryId")int inventoryId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
        pbl.deleteInventory(inventoryId);
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted api";
    }

   @Path("getInventoryById/{inventoryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public ProductInventory getInventoryById(@PathParam("inventoryId")int inventoryId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return pbl.getInventoryById(inventoryId); }

   @Path("getDiscountData")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Collection<Discount> getDiscountData() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return pbl.getDiscountData();
    }

   @Path("addDiscount/{discountName}/{discountDesc}/{active}/{percent}")
    @POST
    
    public String addDiscount(@PathParam("discountName")String discountName,@PathParam("discountDesc") String discountDesc,@PathParam("active") Boolean active,@PathParam("percent") int percent) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
       pbl.addDiscount(discountName, discountDesc, active, percent);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "inserted";
    
    }

 @Path("updateDiscount/{discountId}/{discountName}/{discountDesc}/{active}/{percent}")
    @POST
   
    public String updateDiscount(@PathParam("discountId")int discountId,@PathParam("discountName") String discountName,@PathParam("discountDesc") String discountDesc,@PathParam("active") Boolean active,@PathParam("percent")  int percent) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
      pbl.updateDiscount(discountId, discountName, discountDesc, active, percent);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated api";
    
    }

    @Path("deleteDiscount/{discountId}")
    @DELETE
   
    public String deleteDiscount(@PathParam("discountId")int discountId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   try{
     
         pbl.deleteDiscount(discountId);
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted api";
    }

    @Path("getDiscountById")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Discount getDiscountById(@PathParam("discountId") int discountId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return pbl.getDiscountById(discountId);
    }

    @Path("getDiscountByName/{discountName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Discount getDiscountByName(@PathParam("discountName") String discountName) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return pbl.getDiscountByName(discountName); }
    
    @Path("getAllUsers")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Collection<User> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return  pbl.getAllUsers();}

    @Path("addUser/{userName}/{password}/{email}/{firstName}/{lastName}/{mobile}/{user_img}")
    @POST
    public String addUser(@PathParam("userName") String userName,@PathParam("password") String password,@PathParam("email")String email,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName,@PathParam("mobile") String mobile,@PathParam("user_img") String user_img) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
         System.out.println("restapi"+userName+password+email+firstName+"lastname"+lastName+mobile+user_img);
     pbl.addUser(userName, password, email, firstName,lastName, mobile, user_img);
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "inserted through api";
    
    }

     @Path("updateUser//{userId}{userName}/{password}/{email}/{firstName}/{lastName}/{mobile}/{user_img}")
    @POST
    public String updateUser(@PathParam("userId") int userId,@PathParam("userName") String userName,@PathParam("password") String password,@PathParam("email")String email,@PathParam("firstName") String firstName,@PathParam("LastName") String lastName,@PathParam("mobile") String mobile,@PathParam("user_img") String user_img) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       try{
  
        pbl.updateUser(userId, userName, email, password, firstName, lastName, mobile, user_img);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated api";
    
    }

     @Path("deleteUser/{userId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON) 
    public String deleteUser(@PathParam("userId")int userId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
      pbl.deleteUser(userId);
         
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted api";
    }


    @Path("getUserById")
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public User getUserById(@PathParam("userId")int  userId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return pbl.getUserById(userId);
    }


}
