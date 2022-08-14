/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import entities.Discount;
import entities.Product;
import entities.ProductCategory;
import entities.ProductInventory;
//import static entities.ProductInventory.inventryId;
import entities.Roles;
import entities.User;
import static java.lang.Math.log;
import java.sql.Timestamp; 
import java.time.Instant;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author vpraj
 */
@Stateless
public class studystuffBean implements studystuffBeanLocal {
    @PersistenceContext(unitName ="StudyStuff_1PU")
     private EntityManager em;
     Timestamp instant;
    

    @Override
    public Collection<Product> getProductData() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public String addProduct(String productName, String productDesc, String product_img, int price, int categoryId, int inventoryId, int discountId)
    {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try{
          ProductCategory cat = em.find(ProductCategory.class,categoryId);
        Discount discount = em.find(Discount.class, discountId);
         ProductInventory inventory = em.find(ProductInventory.class,inventoryId);
         Product product = new Product();
         product.setProductName(productName);
         product.setProductDesc(productDesc);
         product.setProductImg(product_img);
         product.setPrice(price);
         product.setCategoryId(cat);
         product.setDiscountId(discount);
         product.setInventoryId(inventory);
         
         instant= Timestamp.from(Instant.now());  
         product.setCreatedAt(instant);
         
         em.persist(product);  
         
        
      }catch(Exception e){
         e.printStackTrace();
         e.getMessage();}
      
       return "inserted";
   
    }

    @Override
    public String updateProduct(int productId, String productName, String productDesc, String product_img, int price, int categoryId, int inventoryId, int discountId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
         //System.out.println("updateProduct bean:="+productId);
          ProductCategory cat = em.find(ProductCategory.class,categoryId);
        Discount discount = em.find(Discount.class, discountId);
         ProductInventory inventory = em.find(ProductInventory.class, inventoryId);
         Product product = em.find(Product.class,productId);
         
         product.setProductName(productName);
         product.setProductDesc(productDesc);
         product.setProductImg(product_img);
         product.setCategoryId(cat);
         product.setDiscountId(discount);
         product.setInventoryId(inventory);
         product.setPrice(price);
         instant= Timestamp.from(Instant.now());  
         product.setModifiedAt(instant);
         
         em.merge(product);  
         
        
      }catch(Exception e){
         e.printStackTrace();
         e.getMessage();}
      
       return "updated";
   
    }

    @Override
    public String deleteProduct(int productId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try{
      
          em.remove(getProductById(productId));
      
      }catch(Exception e){
      e.printStackTrace();
      e.getMessage();}  
      
      return "deleted";
    }

    @Override
    public Product getProductById(int productId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        return (Product)em.createNamedQuery("Product.findByProductId").setParameter("productId", productId).getSingleResult();
    }

    @Override
    public Product getProductByName(String productName) {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return (Product)em.createNamedQuery("Product.findByProductName").setParameter("productName", productName).getSingleResult();
    }

    @Override
    public Collection<Product> getProductDataByCategoryId(int cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ProductCategory cat = em.find(ProductCategory.class,cid);
     return em.createNamedQuery("Product.findByProductCategory").setParameter("categoryId", cid).getResultList();
    }

    @Override
    public Collection<ProductCategory> getCategories() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return em.createNamedQuery("ProductCategory.findAll").getResultList();
    }

    @Override
    public String addCategory(String categoryName, String categoryDesc) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
    ProductCategory cat=new ProductCategory();
    cat.setCategoryName(categoryName);
    cat.setCategoryDesc(categoryDesc);
    instant= Timestamp.from(Instant.now());  
      cat.setCreatedAt(instant);
      em.persist(cat);
    
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "inserted";
    }

    @Override
    public String updateCategory(int categoryId, String categoryName, String categoryDesc) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        ProductCategory cat = em.find(ProductCategory.class,categoryId);
       // cat.setCategoryId(categoryId);
    cat.setCategoryName(categoryName);
    cat.setCategoryDesc(categoryDesc);
    instant= Timestamp.from(Instant.now());  
      cat.setModifiedAt(instant);
      em.merge(cat);
    
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "updated";
    }

    @Override
    public String deleteCategory(int categoryId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
    
           em.remove(getCategoryById(categoryId));
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();
    }
       
       return "deleted";
    }

    @Override
    public ProductCategory getCategoryById(int categoryId) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return (ProductCategory)em.createNamedQuery("ProductCategory.findByCategoryId").setParameter("categoryId", categoryId).getSingleResult();
       
    }

    @Override
    public ProductCategory getCategoryName(String categoryName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return (ProductCategory)em.createNamedQuery("ProductCategory.findByCategoryName").setParameter("categoryName", categoryName).getSingleResult();
    }

    @Override
    public Collection<ProductInventory> getInventoryData() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return em.createNamedQuery("ProductInventory.findAll").getResultList();
    }

    @Override
    public String addInventory(int qty) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        ProductInventory invent=new ProductInventory();
        invent.setQty(qty);
        instant= Timestamp.from(Instant.now()); 
        invent.setCreatedAt(instant);
        em.persist(invent);
        
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "inserted";
    }

    @Override
    public String updateInventory(int inventoryId, int qty) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
              ProductInventory invent = em.find(ProductInventory.class, inventoryId);
        //  invent.setInventryId(inventoryId);
        invent.setQty(qty);
        instant= Timestamp.from(Instant.now()); 
        invent.setModifiedAt(instant);
        em.merge(invent);
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated";
    }
    


    @Override
    public String deleteInventory(int inventoryId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
         em.remove(getInventoryById(inventoryId));
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted";
    }
 @Override
    public ProductInventory getInventoryById(int inventryId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    ProductInventory p=(ProductInventory)em.createNamedQuery("ProductInventory.findById").setParameter("inventryId", inventryId).getSingleResult();
//     System.out.println("GetIn:="+p.getInventryId());
//     return null;
    return (ProductInventory)em.createNamedQuery("ProductInventory.findById").setParameter("inventryId", inventryId).getSingleResult();
    }
   
    @Override
    public Collection<Discount> getDiscountData() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Discount.findAll").getResultList();
    }

    @Override
    public String addDiscount(String discountName, String discountDesc, Boolean active,int percent) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
        Discount dis=new Discount();
        dis.setDiscountName(discountName);
        dis.setDiscountDesc(discountDesc);
        dis.setActive(active);
        dis.setPercent(percent);
      
        instant= Timestamp.from(Instant.now()); 
        dis.setCreatedAt(instant);
        em.persist(dis);
        
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "inserted";
    
    }

    @Override
    public String updateDiscount(int discountId, String discountName, String discountDesc, Boolean active,int percent) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
         Discount dis = em.find(Discount.class, discountId);
        //dis.setDiscountId(discountId);
        dis.setDiscountName(discountName);
        dis.setDiscountDesc(discountDesc);
        dis.setActive(active);
        dis.setPercent(percent);
      
        instant= Timestamp.from(Instant.now()); 
        dis.setCreatedAt(instant);
        em.merge(dis);
        
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated";
    
    }

    @Override
    public String deleteDiscount(int discountId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   try{
       em.remove(getDiscountById(discountId));
         
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted";
    }

    @Override
    public Discount getDiscountById(int discountId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return (Discount)em.createNamedQuery("Discount.findByDiscountId").setParameter("discountId", discountId).getSingleResult();
       
    }

    @Override
    public Discount getDiscountByName(String discountName) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return (Discount)em.createNamedQuery("Discount.findByDiscountName").setParameter("discountName", discountName).getSingleResult();
    }

    @Override
    public Collection<User> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public String addUser(String userName, String password,String email, String firstName, String lastName, String mobile, String user_img) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
         int roleId=202;
          Roles role = em.find(Roles.class,roleId);
        User user=new User();
       user.setUserName(userName);
       user.setPassword(password);
     user.setEmail(email);
     user.setFirstName(firstName);
     user.setLastName(lastName);
     user.setMobile(mobile);
     user.setUserImg(user_img);
     user.setRoleId(role);
     
     
      
        instant= Timestamp.from(Instant.now()); 
        user.setCreatedAt(instant);
        em.persist(user);
        
    
    }catch (ConstraintViolationException e) {
       
       e.getConstraintViolations();
    }
    return "inserted";
    
    }

    @Override
    public String updateUser(int userId, String userName, String password,String email, String firstName, String lastName, String mobile, String user_img) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       try{
        User user = em.find(User.class, userId);
       user.setUserName(userName);
       user.setPassword(password);
     user.setEmail(email);
     user.setFirstName(firstName);
     user.setLastName(lastName);
     user.setMobile(mobile);
     user.setUserImg(user_img);
      
        instant= Timestamp.from(Instant.now()); 
        user.setModifiedAt(instant);
        em.merge(user);
        
    
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "updated";
    
    }

    @Override
    public String deleteUser(int userId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try{
       em.remove(getUserById(userId));
         
    }catch(Exception e){
    e.printStackTrace();
    e.getMessage();}
    return "deleted";
    }


    @Override
    public User getUserById(int userId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return (User)em.createNamedQuery("User.findByUserId").setParameter("userId", userId).getSingleResult();
    
    }

    @Override
    public User Authenticate(String username, String password) {
       return (User)em.createNamedQuery("User.findByUserNameAndPassword").setParameter("userName",username).setParameter("password",password).getSingleResult();
    }

   

    @Override
    public int getRoleOfUser(int userId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     User u1=new User();
      u1= (User)em.createNamedQuery("User.getRoleOfUser").setParameter("userId", userId).getSingleResult();
      
        if(u1.getRoleId().equals(202));
        {
          return 201;
        }
       
    }

    @Override
    public int getProductCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     int count = ((Number)em.createNamedQuery("Product.count").getSingleResult()).intValue();
      System.out.println(count);
      return count;
    }

    @Override
    public int getCategoryCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     int count = ((Number)em.createNamedQuery("ProductCategory.count").getSingleResult()).intValue();
      System.out.println(count);
      return count;
    }

    @Override
    public int getDiscountCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     int count = ((Number)em.createNamedQuery("Discount.count").getSingleResult()).intValue();
      System.out.println(count);
      return count;
    }

    @Override
    public int getUserCount() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    int count = ((Number)em.createNamedQuery("User.count").getSingleResult()).intValue();
      System.out.println(count);
      return count;
    }

}
