package com.gdzc.study.heimaClass.days15;

import java.sql.*;

/**
 * 数据库连接--mysql
 * Created by Liu_Zhichao on 14-10-1.
 */
public class DatabaseConnection {

    /**
     * 普通查询
     */
    public void mysqlConnection(){
        try {
            /*
		    注册驱动分析
		    * 1 Class.forName() 将指定的类加载到内容，获得Class对象
		    * 如果指定的类中存在静态代码块static{....}，将会被执行
		    * 2 com.mysql.jdbc.Driver 实现了 java.sql.Driver接口
		    * 3 com.mysql.jdbc.Driver提供static{...} 进行自己的注册
		    * java.sql.DriverManager.registerDriver(new Driver());
		    * 4 可不可以自己手动注册,可以,但不建议
		    */
            //加载
            Class.forName("com.mysql.jdbc.Driver");
            /*
		 * 获得连接，相当于需要cmd登录,通过URL连接指定的数据库，通过user和password进行登录
		 * 		必须获得连接才可以进行sql语句相应操作
		 * 		接口：java.sql.Connection
		 * URL格式# 协议:子协议:子名称
		 * 		mysql格式#  jdbc:mysql://ip地址:端口/数据库名称  ， ip地址默认localhost，端口默认3306
		 * 				url简写#  jdbc:mysql:///day15
		 * 		oracle格式#	jdbc:oracle:thin:@ip地址:1521:数据库名称
		 * 				默认端口：1521
		 * 				例如：jdbc:oracle:thin:@localhost:1521:orcl
		 * api :
		 * 		Statement conn.createStatement() 获得语句执行者
		 * 		PreparedStatement conn.prepareStatment(String sql) 获得预处理对象
		 * 		CallableStatement conn.prepareCall(sql) ,获得可以指定存储过程的对象 -- 存储过程：数据库已经编写好了sql语句的函数--速度快。
		 */
            //获得和数据库的链接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kikyou","root","root");
            /*
		 * 获得语句执行者详解
		 * * 接口：java.sql.Statement,此接口的实现类，可以执行sql语句
		 * * 获得方式
		 * 		* 默认方式：conn.createStatement()
		 * 		* 指定参数：conn.createStatement(int resultSetType, int resultSetConcurrency);
		 * 			resultSetType - 结果集类型
		 * 				ResultSet.TYPE_FORWARD_ONLY,rs游标只能向下移动
		 * 				ResultSet.TYPE_SCROLL_INSENSITIVE，rs游标可以向下移动，也可以向上移动，但在移动的过程中数据库中的数据发生了改变，不获得(不敏感)
		 * 				ResultSet.TYPE_SCROLL_SENSITIVE，rs游标可以向下移动，也可以向上移动，但在移动的过程中数据库中的数据发生了改变，获得(敏感)
		 * 			resultSetConcurrency - 并发类型
		 * 				ResultSet.CONCUR_READ_ONLY,rs为只读，不能获得更新的数据
		 * 				ResultSet.CONCUR_UPDATABLE，rs可以获得更新的数据。
		 *			组合
		 *				TYPE_FORWARD_ONLY 和 CONCUR_READ_ONLY 只读
		 *				TYPE_SCROLL_SENSITIVE 和 CONCUR_UPDATABLE 可获得更新
		 * * api
		 * 		ResultSet st.exeucteQuery(sql) , 执行DQL语句(查询) ， ResultSet封装所有的查询结果
		 * 		int st.executeUpdate(sql), 执行DML语句(增删改)，也可以执行DDL， int存放的更新的影响行数。
		 * 		boolean st.exeucte(sql); 执行所有的sql语句(DQL和DML都行)  -- 了解
		 * 			true：执行DQL，st.getResultSet() 获得结果集
		 * 			false ： 执行DML ，st.getUpdateCount() 获得影响行数
		 * * ResultSet 结果集：用于封装查询的所有数据
		 * 		rs.next() ,向下移动
		 * 		rs.previous() ,向上移动
		 * 		rs.getXxx() 获得数据
		 * 			rs.getXxx(String columnName) 通过指定的列名获得的
		 * 			rs.getXxx(int columnIndex) 从1开始
		 * 			例如：
		 * 				String id = rs.getString("id") 获得id值
		 * 				int age = rs.getInt(5) 获得第5列的值
		 */
            //获得sql语句执行者
            Statement st = conn.createStatement();
            //执行查询语句
            ResultSet rs = st.executeQuery("查询的sql语句");
            //循环遍历获取查询结果
            while (rs.next()){
                rs.getString("列名");//列的名字
                rs.getString(1);//列数
                rs.getInt("id");
            }
            //执行DML语句(增删改)，返回值是受影响的行数
            int r = st.executeUpdate("DML的sql语句");
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 参数化查询
     */
    public void mysqlConn(){
        try {
            //加载
            Class.forName("com.mysql.jdbc.Driver");
            //获得和数据库的链接
            Connection conn = DriverManager.getConnection("");
            //获得sql语句预处理对象
            PreparedStatement ps = conn.prepareStatement("查询语句????");
            //添加参数，第一个参数表示对应第几个问号
            ps.setString(1,"参数化查询");
            ps.setInt(1,2);
            //查询结果
            ResultSet rs = ps.executeQuery();
            int r = ps.executeUpdate();
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批处理(批量处理sql语句)
     * -可以写多条不同类型的sql语句，然后批量执行
     */
    public void mysqlConnectionBatch(){
        try {
            //加载
            Class.forName("com.mysql.jdbc.Driver");
            //获得和数据库的链接
            Connection conn = DriverManager.getConnection("");
            //获得sql语句执行者
            Statement st = conn.createStatement();
            //添加多条sql语句
            st.addBatch("不同的sql语句");
            st.addBatch("不同的sql语句");
            //批量执行sql语句
            int[] results = st.executeBatch();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批处理(批量处理sql语句)
     * -只能写一条sql语句，但是可以添加多组参数
     */
    public void mysqlConnBatch(String ... ids){
        try {
            //加载
            Class.forName("com.mysql.jdbc.Driver");
            //获得和数据库的链接
            Connection conn = DriverManager.getConnection("");
            //获得sql语句执行者
            PreparedStatement ps = conn.prepareStatement("查询语句?占位");
            for (String id : ids){
                //执行查询语句
                ps.setString(1,"参数化查询");
                ps.setInt(1,2);
                ps.addBatch();//添加到缓存
            }
            int[] resules = ps.executeBatch();//批量执行sql语句
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
