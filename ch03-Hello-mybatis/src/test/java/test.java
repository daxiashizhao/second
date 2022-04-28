import com.hbsi.dao.EmployeeDao;
import com.hbsi.pojo.Employee;
import com.hbsi.utils.MyBatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    //查询
    @Test
    public void TestfinUsersById(){

        SqlSession sqlSession=MyBatisUtils.getSession();
        EmployeeDao dao=sqlSession.getMapper(EmployeeDao.class);
        Employee employee=dao.finUsersById(11);
        System.out.println(employee);
        System.out.println(sqlSession.getMapper(EmployeeDao.class));
    }
 //插入
      @Test
    public void TestaddEmployee(){
          SqlSession sqlSession=MyBatisUtils.getSession();
          EmployeeDao dao=sqlSession.getMapper(EmployeeDao.class);
          Employee employee=new Employee();
          employee.setName("赵六");
          employee.setAge(23);
          employee.setPosition("董事长");
          int nums=dao.addEmployee(employee);

          if (nums>0){
              System.out.println("插入成功");
          }else {
              System.out.println("插入失败");
          }
          sqlSession.commit();
      }
      //删除记录
    @Test
    public void   TestdeleteUsers(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        EmployeeDao dao=sqlSession.getMapper(EmployeeDao.class);
        int nms=dao.deleteUsers(9);
        sqlSession.commit();
        if (nms>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }
    //修改数据库
    @Test
    public void TestupdateUsers(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        EmployeeDao dao=sqlSession.getMapper(EmployeeDao.class);
        Employee employee=new Employee();
        employee.setId(10);
        employee.setName("乔峰");
        employee.setAge(30);
        employee.setPosition("丐帮帮主");
        int nums=dao.updateUsers(employee);
        sqlSession.commit();
        if (nums>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }


    }


}
