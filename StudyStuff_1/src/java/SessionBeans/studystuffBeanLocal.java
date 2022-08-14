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
import entities.User;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author vpraj
 */
@Local
public interface studystuffBeanLocal {
    //for product
    Collection<Product> getProductData();
    String addProduct(String productName,String productDesc,String product_img,int price,int categoryId,int inventoryId,int discountId);
    String updateProduct(int productId,String productName,String productDesc,String product_img,int price,int categoryId,int inventoryId,int discountId);
    String deleteProduct(int productId);
    Product getProductById(int productId);
    Product getProductByName(String productName);
    public Collection<Product> getProductDataByCategoryId(int cid);
    int getProductCount();
    
    //product_category
    Collection<ProductCategory> getCategories();
    String addCategory(String categoryName,String categoryDesc);
    String updateCategory(int categoryId,String categoryName,String categoryDesc);
    String deleteCategory(int categoryId);
    ProductCategory getCategoryById(int categoryId);
    ProductCategory getCategoryName(String categoryName);
    int getCategoryCount();
    
    //product_inventory
    Collection<ProductInventory> getInventoryData();
    String addInventory(int qty);
    
    String updateInventory(int inventoryId,int qty);
    String deleteInventory(int inventoryId);
    ProductInventory getInventoryById(int inventoryId);
    
    
    //discount
    Collection<Discount> getDiscountData();
    String addDiscount(String discountName,String discountDesc,Boolean active,int percent);
    String updateDiscount(int discountId,String discountName,String discountDesc,Boolean active,int percent);
    String deleteDiscount(int discountId);
    Discount getDiscountById(int discountId);
    Discount getDiscountByName(String discountName);
    int getDiscountCount();
    
    //user
    Collection<User> getAllUsers();
    String addUser(String userName,String password,String email,String firstName,String lastName,String mobile,String user_img);
    String updateUser(int userId,String userName,String email,String password,String firstName,String lastName,String mobile,String user_img);
    String deleteUser(int userId);
    User getUserById(int userId);
    int getRoleOfUser(int userId);
    User Authenticate(String username,String password);
    int getUserCount();
    
    
    
    
}
