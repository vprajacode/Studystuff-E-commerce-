/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import RestClient.NewClient;
import SessionBeans.studystuffBeanLocal;
import entities.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 *
 * @author vpraj
 */
@Named(value = "clientBean")
@ApplicationScoped
public class ClientBean {
    @EJB studystuffBeanLocal pbl;
    Response rs;
    NewClient jc;
    
    Integer userid,RoleId;

    
    Boolean check,auth;
    String firstname,lastname,mobile,email,new_password;
    String username,password,adminname,user_img="abc",new_username,uname,first;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Boolean getCheck() {
        return check;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        this.RoleId = roleId;
    }
    

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getNew_username() {
        return new_username;
    }

    public void setNew_username(String new_username) {
        this.new_username = new_username;
    }
    
    User user=new User();
     

   @PostConstruct
    public void init()
    {
        jc= new NewClient();
        userid=0;
        new_password="";
        firstname="";
        lastname="";
        mobile="";
        username="";
       
    }
    public ClientBean() {
    }
    
     
      public String authenticate()
    {

        try {
            if(username.equals("Vishu") && password.equals("visu"))
            {
               
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("admin", username);
                    adminname=(String)session.getAttribute("admin");
                     session.setAttribute("firstName",user.getFirstName());
//                 
                    return "/admin/index.xhtml?faces-redirect=true";
            }
            else
            {
                Integer UserId = LoginDAO.validate(username,password);
                user=pbl.getUserById(UserId);
                System.out.println("roleid"+user.getRoleId().getRoleId());
                if(user.getUserName().equals(username) && user.getPassword().equals(password)&& user.getRoleId().getRoleId().equals(202))
                {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                     session.setAttribute("firstName",user.getFirstName());
                     uname=(String)session.getAttribute("username");          
                   
                    return "/clientside/index.xhtml?faces-redirect=true";
                }
               
                else
                {
                    FacesContext.getCurrentInstance().addMessage(
                                            null,
                                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                            "Incorrect Username and Password",
                                                            "Please enter correct username and Password"));
                    System.out.println("Incorrect password");
                    return "/clientside/loginpage.xhtml?faces-redirect=true";
                }
            }
            
        } catch (Exception e) {
            System.out.println("authenticate:="+e.getMessage());
            return "/clientside/loginpage.xhtml?faces-redirect=true";
        }
    }
    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
                clearAll();
		return "/clientside/loginpage.xhtml?faces-redirect=true";
	}
     public String ulogout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
                clearAll();
		return "/loginpage.xhtml?faces-redirect=true";
	}
    
    public String adduser()
    {
        try {
          
           System.out.println("Adduser:="+new_username+"/"+email+"/"+new_password+"/"+firstname+"/"+lastname+"/"+mobile);
           
         
           jc.addUser(new_username,new_password,email,firstname,lastname,mobile,user_img);
           clearAll();
           return "/clientside/index.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
    }

    
    
    
   public  void clearAll()
    {
        userid=0;
        username="";password="";new_username="";new_password="";
        firstname="";lastname="";mobile="";email="";
    }
    
}
