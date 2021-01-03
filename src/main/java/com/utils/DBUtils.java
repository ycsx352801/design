package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtils {

    //连接数据库
    public static Connection getConnection() throws Exception {
        //读取配置文件
        InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        System.out.println(in);
        Properties properties=new Properties();
        properties.load(in);
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    //类型参数，类型变量，类型是可以变化 Teacher Student
    //clazz User.class字节码文件
    //查询表格全部信息
    public static <T> List<T> getList(Class<T> clazz,String sql,Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> userList=null;
        try{
            //连接数据库
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                    //ps.setObject(1,args[i]);
                }
            }

            rs=ps.executeQuery();
            //获取结果集元素
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取当前结果集的列数
            int colnum=rsmd.getColumnCount();
            userList=new ArrayList<T>();
            while(rs.next()){
                //key存放列名，value存放列值，for循环结束后，rowMap存放一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colnum;i++){
                    String columnName=rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if(columnValue instanceof java.sql.Date){
                        java.sql.Date date=(java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值
                T bean=clazz.newInstance();
                //根据列名，id==给User对象id属性赋值的方法名，setUser_id,"set"+User_id=setUser_id,调用setUser_id方法给user对象赋值，map中的calue
                //循环rowMap给User所有属性赋值 entry{key,value}
                for(Map.Entry<String ,Object> entry:rowMap.entrySet()){
                    String propertyName=entry.getKey();
                    Object propertyValue=entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }
                userList.add(bean);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

        return userList;
    }

    //关闭相关数据库
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //保存对象
    public static boolean save(String sql,Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        Integer count=null;
        try{
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            //返回更新的记录数
            count=ps.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            close(conn, ps, null);
        }

        return count!=null&&count>0?true:false;
    }

    //查询表格部分信息
    public static <T> T getSingleObj(Class<T> clazz,String sql,Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        T bean=null;
        try{
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            rs=ps.executeQuery();
            //获取结果集元素
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取当前结果集的列数
            int colnum=rsmd.getColumnCount();
            while(rs.next()){
                //key存放列名，value存放列值，for循环结束后，rowMap存放一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colnum;i++){
                    String columnName=rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if(columnValue instanceof java.sql.Date){
                        java.sql.Date date=(java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值
                bean=clazz.newInstance();
                //根据列名，id==给User对象id属性赋值的方法名，setUser_id,"set"+User_id=setUser_id,调用setUser_id方法给user对象赋值，map中的calue
                //循环rowMap给User所有属性赋值 entry{key,value}
                for(Map.Entry<String ,Object> entry:rowMap.entrySet()){
                    String propertyName=entry.getKey();
                    Object propertyValue=entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

        return bean;
    }

    //查询表格返回ID
    public static Integer getCount(String sql) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer count=0;
        try{
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               count=rs.getInt("APPLICANT_ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

        return count;
    }

    //修改信息
    public static Integer update(String sql,Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        Integer count=null;
        try{
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            count=ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            close(conn, ps, null);
        }
        return count;
    }

    //删除表格内容
    public static boolean delete(String sql,Object...args){
        Connection conn =null;
        PreparedStatement ps=null;
        Integer count=null;
        try{
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            //返回更新的记录数
            count=ps.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            close(conn, ps, null);
        }
        return count!=null&&count>0?true:false;
    }
}
