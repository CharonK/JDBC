package com.qinli.puzzle02.dao;

import com.qinli.puzzle02.entity.Student;
import com.qinli.puzzle02.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cambria
 * @creat 2021/2/7 20:54
 */
public class StudentDao {
    public static List<Student> selectAll(){
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";

        //在下面写查询语句
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {//获取对象并执行sql
            //Class.forName("com.mysql.jdbc.Driver");
            con = JDBCUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            //遍历结果集
            Student student =null;
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return students;
    }
}
