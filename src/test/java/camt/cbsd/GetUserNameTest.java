package camt.cbsd;
import camt.cbsd.dao.CourseDao;
import camt.cbsd.dao.StudentDao;
import camt.cbsd.entity.Student;
import camt.cbsd.entity.security.User;
import camt.cbsd.services.CourseService;
import camt.cbsd.services.CourseServiceImpl;
import camt.cbsd.services.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 14/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetUserNameTest {

    StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }
    StudentServiceImpl studentService;
    @Test
    public void testGetUsername(){

        String imageBaseUrl = "http://localhost:8080/student/images/";

        Student student1 = Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl+"mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Student student2 = Student.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl+"tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Student student3 = Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl+"Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);

        assertThat(studentService.getUsername("eiei"), is(nullValue()));

        assertThat(studentService.getUsername("admin").getStudentId(), is(student1.getStudentId()));
        assertThat(studentService.getUsername("admin").getName(), is(student1.getName()));
        assertThat(studentService.getUsername("admin").getSurname(), is(student1.getSurname()));
        assertThat(studentService.getUsername("admin").getGpa(), is(student1.getGpa()));
        assertThat(studentService.getUsername("admin").getImage(), is(student1.getImage()));
        assertThat(studentService.getUsername("admin").isFeature(), is(student1.isFeature()));
        assertThat(studentService.getUsername("admin").getPenAmount(), is(student1.getPenAmount()));
        assertThat(studentService.getUsername("admin").getDescription(), is(student1.getDescription()));

        assertThat(studentService.getUsername("user").getStudentId(), is(student2.getStudentId()));
        assertThat(studentService.getUsername("user").getName(), is(student2.getName()));
        assertThat(studentService.getUsername("user").getSurname(), is(student2.getSurname()));
        assertThat(studentService.getUsername("user").getGpa(), is(student2.getGpa()));
        assertThat(studentService.getUsername("user").getImage(), is(student2.getImage()));
        assertThat(studentService.getUsername("user").isFeature(), is(student2.isFeature()));
        assertThat(studentService.getUsername("user").getPenAmount(), is(student2.getPenAmount()));
        assertThat(studentService.getUsername("user").getDescription(), is(student2.getDescription()));

        assertThat(studentService.getUsername("disabled").getStudentId(), is(student3.getStudentId()));
        assertThat(studentService.getUsername("disabled").getName(), is(student3.getName()));
        assertThat(studentService.getUsername("disabled").getSurname(), is(student3.getSurname()));
        assertThat(studentService.getUsername("disabled").getGpa(), is(student3.getGpa()));
        assertThat(studentService.getUsername("disabled").getImage(), is(student3.getImage()));
        assertThat(studentService.getUsername("disabled").isFeature(), is(student3.isFeature()));
        assertThat(studentService.getUsername("disabled").getPenAmount(), is(student3.getPenAmount()));
        assertThat(studentService.getUsername("disabled").getDescription(), is(student3.getDescription()));
    }


}
