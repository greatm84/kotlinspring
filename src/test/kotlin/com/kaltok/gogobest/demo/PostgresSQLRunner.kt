//package com.kaltok.gogobest.demo
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.ApplicationArguments
//import org.springframework.boot.ApplicationRunner
//import org.springframework.jdbc.core.JdbcTemplate
//import org.springframework.stereotype.Component
//import java.sql.Statement
//import javax.sql.DataSource
//
//
//@Component
//class PostgreSQLRunner : ApplicationRunner {
//    @Autowired
//    lateinit var dataSource: DataSource
//
//    @Autowired
//    lateinit var jdbcTemplate: JdbcTemplate
//
//    @Throws(Exception::class)
//    override fun run(args: ApplicationArguments) {
//        dataSource.connection.use { connection ->
//            println(dataSource::class.java)
//            println(connection.metaData.url)
//            println(connection.metaData.userName)
//            val statement: Statement = connection.createStatement()
//            val sql =
//                "CREATE TABLE IF NOT EXISTS t_product(product_no INTEGER NOT NULL, product_name VARCHAR(255), PRIMARY KEY (product_no))"
//            statement.executeUpdate(sql)
//        }
//        jdbcTemplate.execute("INSERT INTO t_product VALUES (1, 'Big shirt')")
//    }
//}