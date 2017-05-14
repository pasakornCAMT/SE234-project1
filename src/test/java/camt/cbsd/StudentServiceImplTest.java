package camt.cbsd;

import camt.cbsd.dao.StudentDao;
import camt.cbsd.entity.Student;
import camt.cbsd.services.StudentServiceImpl;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

/**
 * Created by User on 14/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    StudentDao studentDao;
    StudentServiceImpl studentService;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }
    @Test
    public void queryStudentTest(){

        studentService=new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        //Denote, get(index of student list for each case or query in database)
        //nothing input query
        assertThat(studentService.queryStudent("").get(0).getUser().getUsername(),is("admin"));
        assertThat(studentService.queryStudent("").get(1).getUser().getUsername(),is("user"));
        assertThat(studentService.queryStudent("").get(2).getUser().getUsername(),is("disabled"));
        //input name
        assertThat(studentService.queryStudent("Mitsuha").get(0).getUser().getUsername(),is("admin"));
        assertThat(studentService.queryStudent("Prayuth").get(0).getUser().getUsername(),is("user"));
        assertThat(studentService.queryStudent("Kloop").get(0).getUser().getUsername(),is("disabled"));
        //input some word
        assertThat(studentService.queryStudent("tsu").get(0).getUser().getUsername(),is("admin"));
        assertThat(studentService.queryStudent("yu").get(0).getUser().getUsername(),is("user"));
        assertThat(studentService.queryStudent("oo").get(0).getUser().getUsername(),is("disabled"));

    }
}
