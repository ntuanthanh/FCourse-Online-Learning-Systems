/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Blog;
import model.Category;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jicon
 */
public class BlogDBContext extends DBContext {
    
//    public ArrayList<Blog> getBlogForHome() {
//        ArrayList<Blog> blogs = new ArrayList<>();
//        try {
//            String sql = "SELECT top(3) Blog.*, Category.value, [user].fullname\n"
//                    + "FROM     Blog INNER JOIN\n"
//                    + "                  Category ON Blog.CategoryId = Category.Categoryid\n"
//                    + "				  inner join [User] on  [User].Userid = Blog.UserId\n"
//                    + "				  where Blog.StatusId=1 \n"
//                    + "				  order by createdate desc ";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Blog b = new Blog();
//                b.setId(rs.getInt(1));
//                b.setBrief(rs.getString(2));
//                b.setContent(rs.getString(2));
//                b.setThumbnail(rs.getString(4));
//                b.setCreatedate(rs.getDate(5));
//                
//                b.setTitle(rs.getString(6));
//                
//                Category ca = new Category();
//                ca.setCategoryID(rs.getInt(7));
//                ca.setValue(rs.getString(10));
//                b.setCategory(ca);
//                User u = new User();
//                u.setId(rs.getInt(9));
//                u.setFullName(rs.getString(11));
//                
//                b.setUser(u);
//                blogs.add(b);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return blogs;
//    }
    
     public ArrayList<Blog> getBlogs()
    {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            
            String sql ="select top(6) b.id, b.brief, b.Thumbnail, b.Title, b.CategoryId, b.StatusId, b.UserId, u.fullname\n" +
                        "from Blog b inner join [User] u on u.UserId= b.UserId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Blog b = new Blog();
                User u = new User();
                b.setId(rs.getInt("id"));
                b.setBrief(rs.getString("brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setTitle(rs.getString("title"));
                b.setCategoryId(rs.getInt("CategoryId"));
                b.setStatusId(rs.getInt("StatusId"));
                u.setFullName(rs.getString("fullname"));
                b.setUser(u);
                blogs.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    //select blog by BlogId
    public Blog getBlog(String bid)
    {
        try {
            String sql ="select b.id, b.brief, b.Thumbnail, b.content, b.Title, b.CategoryId, b.StatusId, b.UserId, u.fullname, c.value, b.createdate\n" +
"                        from Blog b inner join [User] u on u.UserId= b.UserId\n" +
"                        inner join Category c on b.CategoryId= c.Categoryid\n" +
"                        where b.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bid);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Blog b = new Blog();
                User u = new User();
                Category c = new Category();
                b.setId(rs.getInt("id"));
                b.setBrief(rs.getString("brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setContent(rs.getString("content"));
                b.setTitle(rs.getString("title"));
                b.setCategoryId(rs.getInt("CategoryId"));
                b.setStatusId(rs.getInt("StatusId"));
                u.setFullName(rs.getString("fullname"));
                c.setValue(rs.getString("value"));
                b.setUser(u);
                b.setCreatedate(rs.getDate("createdate"));
                b.setCategory(c);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Blog> getBlogForHome() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Blog.Id, Blog.Brief, Blog.Thumbnail, Blog.Title, Blog.CategoryId, Blog.StatusId, Blog.UserId, Blog.createdate, Category.value, [user].fullname\n" +
"                    FROM     Blog INNER JOIN\n" +
"                                      Category ON Blog.CategoryId = Category.Categoryid\n" +
"                    				  inner join [User] on  [User].Userid = Blog.UserId\n" +
"                    				  where Blog.StatusId=1 \n" +
"                    				  order by createdate desc ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("Id"));
                b.setBrief(rs.getString("Brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setCreatedate(rs.getDate("createdate"));
                
                b.setTitle(rs.getString("title"));
                
                Category ca = new Category();
                ca.setCategoryID(rs.getInt("CategoryId"));
                ca.setValue(rs.getString("Value"));
                b.setCategory(ca);
                User u = new User();
                u.setId(rs.getInt("UserId"));
                u.setFullName(rs.getString("fullname"));
                
                b.setUser(u);
                blogs.add(b);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    public static void main(String[] args){
        BlogDBContext a = new BlogDBContext();
        ArrayList<Blog> blogs = a.getBlogForHome();
        System.out.println(blogs.size());
        
//        ArrayList<Serie> list = a.getSeriesViews();
//        for(Serie s: list){
//            System.out.println(s);
//        }
//        Serie b = a.getSerie("1");
////        int s = a.getSid();
//        System.out.println(b);
    }
}
