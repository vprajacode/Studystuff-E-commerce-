/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import RestClient.NewClient;
import SessionBeans.studystuffBeanLocal;
import entities.Discount;
import entities.Product;
import entities.ProductCategory;
import entities.ProductInventory;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author vpraj
 */
@Named(value = "adminBean")
@ApplicationScoped
public class AdminBean {
    
     @EJB studystuffBeanLocal pbl;
    Response rs;
    NewClient jc;
    Integer productId,price,categoryId,inventoryId,discountId,quantity,userId,percent,count;

    

   
    Boolean active;

    
    String productName,productDesc,product_img,CategoryName,CategoryDesc,qty,discountName,discountDesc;
//user
    String username,mobile,email,uimg;
    Part file;
    
    

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
            
          
         

     
     

   
    
    // String clickdata;
    Collection<Product> getproduct;
    GenericType<Collection<Product>> gproduct;
     Collection<ProductCategory> getcategory;
    GenericType<Collection<ProductCategory>> gcategory;
     Collection<ProductInventory> getinventory;
    GenericType<Collection<ProductInventory>> ginventory;
     Collection<Discount> getdiscount;
    GenericType<Collection<Discount>> gdiscount;
    Collection<User> getuser;
    GenericType<Collection<User>> guser;
    
    
    
    Product productobj= new Product();
    ProductCategory catobj=new ProductCategory();
    ProductInventory inventobj=new ProductInventory();
    Discount discountobj=new Discount();
    User userobj=new User();
    
    
   
      @PostConstruct
    public void init()
    {
        jc= new NewClient();
      productId=0;
      categoryId=0;
      discountId=0;
      inventoryId=0;
      
    }
    
    public AdminBean() {
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Collection<User> getGetuser() {
        return getuser;
    }

    public void setGetuser(Collection<User> getuser) {
        this.getuser = getuser;
    }

    public GenericType<Collection<User>> getGuser() {
        return guser;
    }

    public void setGuser(GenericType<Collection<User>> guser) {
        this.guser = guser;
    }

    public User getUserobj() {
        return userobj;
    }

    public void setUserobj(User userobj) {
        this.userobj = userobj;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }
   
     public String getCategoryDesc() {
        return CategoryDesc;
    }

    public void setCategoryDesc(String CategoryDesc) {
        this.CategoryDesc = CategoryDesc;
    }
     public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Collection<ProductCategory> getGetcategory() {
        return getcategory;
    }

    public void setGetcategory(Collection<ProductCategory> getcategory) {
        this.getcategory = getcategory;
    }

    public GenericType<Collection<ProductCategory>> getGcategory() {
        return gcategory;
    }

    public void setGcategory(GenericType<Collection<ProductCategory>> gcategory) {
        this.gcategory = gcategory;
    }

    public Collection<ProductInventory> getGetinventory() {
        return getinventory;
    }

    public void setGetinventory(Collection<ProductInventory> getinventory) {
        this.getinventory = getinventory;
    }

    public GenericType<Collection<ProductInventory>> getGinventory() {
        return ginventory;
    }

    public void setGinventory(GenericType<Collection<ProductInventory>> ginventory) {
        this.ginventory = ginventory;
    }

    public Collection<Discount> getGetdiscount() {
        return getdiscount;
    }

    public void setGetdiscount(Collection<Discount> getdiscount) {
        this.getdiscount = getdiscount;
    }

    public GenericType<Collection<Discount>> getGdiscount() {
        return gdiscount;
    }

    public void setGdiscount(GenericType<Collection<Discount>> gdiscount) {
        this.gdiscount = gdiscount;
    }

    public ProductCategory getCatobj() {
        return catobj;
    }

    public void setCatobj(ProductCategory catobj) {
        this.catobj = catobj;
    }

    public ProductInventory getInventobj() {
        return inventobj;
    }

    public void setInventobj(ProductInventory inventobj) {
        this.inventobj = inventobj;
    }

    public Discount getDiscountobj() {
        return discountobj;
    }

    public void setDiscountobj(Discount discountobj) {
        this.discountobj = discountobj;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
 public Product getProductobj() {
        return productobj;
    }

    public void setProductobj(Product productobj) {
        this.productobj = productobj;
    }
    
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

   

    public Collection<Product> getGetproduct() {
        return getproduct;
    }

    public void setGetproduct(Collection<Product> getproduct) {
        this.getproduct = getproduct;
    }

    public GenericType<Collection<Product>> getGproduct() {
        return gproduct;
    }

    public void setGproduct(GenericType<Collection<Product>> gproduct) {
        this.gproduct = gproduct;
    }
     public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc;
    }
    
    public Collection<Product> showproductdata()
   {
        gproduct=new GenericType<Collection<Product>>(){};
        rs=jc.getProductData(Response.class) ;
        getproduct=rs.readEntity(gproduct);
       
       return getproduct;
   }
    
    public String addnewproduct()
   {
      
       try {
            InputStream input = file.getInputStream();
            String path = "C:\\Users\\vpraj\\Documents\\NetBeansProjects\\StudyStuff_1\\web\\pics\\";
            
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            product_img = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, product_img).toPath());
          // clearAll();
              System.out.println(" managed Add product:="+productName+" "+productDesc+"img "+product_img+" "+price+" "+categoryId+" "+inventoryId+" "+discountId );
           System.out.println("Add product:="+jc.addProduct(productName, productDesc, product_img, String.valueOf(price), String.valueOf(categoryId), String.valueOf(inventoryId) , String.valueOf(discountId) ));
             productName="";productDesc="";product_img="";price=0;categoryId=0;inventoryId=0;discountId=0;
          
        return "product.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
         
          
       }
   }
   
   public String searchproduct(Integer pid)
   {
       try {
           productobj=pbl.getProductById(pid);
           productId=productobj.getProductId();
           productName=productobj.getProductName();
           productDesc=productobj.getProductDesc();
           product_img=productobj.getProductImg();
           price=productobj.getPrice();
           categoryId=productobj.getCategoryId().getCategoryId();
           inventoryId=productobj.getInventoryId().getInventryId();
           discountId=productobj.getDiscountId().getDiscountId();
           return "addproduct.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updateproduct()
   {
      
       try {
            InputStream input = file.getInputStream();
            String path = "C:\\Users\\vpraj\\Documents\\NetBeansProjects\\StudyStuff_1\\web\\pics\\";
            
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            product_img = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, product_img).toPath());
           
           System.out.println("updateproduct:="+jc.updateProduct(String.valueOf(productId), productName, productDesc, product_img, String.valueOf(price),String.valueOf(categoryId) ,String.valueOf(inventoryId),String.valueOf(discountId)));
           clearAll();
           return "product.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deleteproduct(Integer id){
        try{
            jc.deleteProduct(String.valueOf(id));
            return "product.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
   // category
   
    public Collection<ProductCategory> showcategory()
   {
        gcategory=new GenericType<Collection<ProductCategory>>(){};
        rs=jc.getCategories(Response.class) ;
        getcategory=rs.readEntity(gcategory);
       
       return getcategory;
   }
    public String addcategory()
   {
      
       try {
           
           System.out.println("Addcategory:="+jc.addCategory(CategoryName, CategoryDesc));
           clearAll();
         
           return "category.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
      public String searchcategory(Integer cid)
   {
       try {
           catobj=pbl.getCategoryById(cid);
           categoryId=catobj.getCategoryId();
           CategoryName=catobj.getCategoryName();
           CategoryDesc=catobj.getCategoryDesc();
           
           return "addcategories.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updatepcategory()
   {
      
       try {
           
           System.out.println("updatepcategory:="+jc.updateCategory(String.valueOf(categoryId), CategoryName, CategoryDesc));
           clearAll();
           return "category.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deletecategory(Integer id){
        try{
            jc.deleteCategory(String.valueOf(id));
            return "category.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
       public Collection<ProductInventory> showinventory()
   {
        ginventory=new GenericType<Collection<ProductInventory>>(){};
        rs=jc.getInventoryData(Response.class);
        getinventory=rs.readEntity(ginventory);
       
       return getinventory;
   }
       
     public String addinventory()
   {
      
       try {
           System.out.println("add inventory:="+quantity);
           System.out.println("addinventory:="+jc.addInventory(String.valueOf(quantity)));
           clearAll();
           return "inventory.xhtml?faces-redirect=true";
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }  
     
       public String searchinventory(Integer cid)
   {
       try {
           inventobj=pbl.getInventoryById(cid);
           inventoryId=inventobj.getInventryId();
           quantity=inventobj.getQty();
          
           
           return "addinventory.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updateinventory()
   {
      
       try {
           
           System.out.println("updateinventory:="+jc.updateInventory(String.valueOf(inventoryId), String.valueOf(quantity)));
           clearAll();
           return "inventory.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deleteinventory(Integer vid){
        try{
            jc.deleteInventory(String.valueOf(vid));
            return "inventory.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
       
    //discount    
          public Collection<Discount> showdiscount()
   {
        gdiscount=new GenericType<Collection<Discount>>(){};
        rs=jc.getDiscountData(Response.class) ;
        getdiscount=rs.readEntity(gdiscount);
       
       return getdiscount;
   }
       public String addDiscount()
   {
      
       try {
           
           System.out.println("addDiscount:="+jc.addDiscount(discountName, discountDesc, String.valueOf(active), String.valueOf(percent)));
           clearAll();
         
           return "discount.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
      public String searchdiscount(Integer cid)
   {
       try {
           discountobj=pbl.getDiscountById(cid);
           discountId=discountobj.getDiscountId();
           discountName=discountobj.getDiscountName();
           discountDesc=discountobj.getDiscountDesc();
           active=discountobj.getActive();
           
           return "addDiscount.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updatediscount()
   {
      
       try {
           
           System.out.println("updatepcategory:="+jc.updateDiscount(String.valueOf(discountId), discountName, discountDesc, String.valueOf(active), String.valueOf(percent)));
           clearAll();
           return "discount.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deletediscount(Integer id){
        try{
            jc.deleteDiscount(String.valueOf(id));
            return "discount.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }   
//user

    public Collection<User> showUserdetails()
   {
        guser=new GenericType<Collection<User>>(){};
        rs=jc.getAllUsers(Response.class) ;
        getuser=rs.readEntity(guser);
       
       return getuser;
   }  
    
    public String deleteuser(Integer id){
        try{
         jc.deleteUser(String.valueOf(id));
            return "user.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
     public int getproductcount( ){
        try{
         
            return pbl.getProductCount();
        }catch(Exception e){
             e.getMessage();
             return 0;
        }
    }
      public int getcategorycount( ){
        try{
         
            return pbl.getCategoryCount();
        }catch(Exception e){
             e.getMessage();
             return 0;
        }
    }
       public int getdiscountcount( ){
        try{
         
            return pbl.getDiscountCount();
        }catch(Exception e){
             e.getMessage();
             return 0;
        }
    }
        public int getusercount( ){
        try{
         
            return pbl.getUserCount();
        }catch(Exception e){
             e.getMessage();
             return 0;
        }
    }
          
    public void clearAll()
   {
       productId=0;
       productName="";
       productDesc="";
       categoryId=0;
       discountId=0;
       inventoryId=0;
       CategoryDesc="";
       discountName="";
      product_img="";
       quantity=0;
       CategoryName="";
       discountDesc="";
       percent=0;
       
   }

  
   
    
}
