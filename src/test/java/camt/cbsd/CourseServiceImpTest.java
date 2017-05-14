package camt.cbsd;
import camt.cbsd.dao.CourseDao;
import camt.cbsd.services.CourseService;
import camt.cbsd.services.CourseServiceImpl;
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
import static org.junit.Assert.assertEquals;
/**
 * Created by User on 14/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImpTest {
    @Autowired
    public void setCourseDao(CourseDao course){
        this.courseDao=course;
    }
    CourseDao courseDao;
    @Test
    public void testGetCourseCount(){
        CourseServiceImpl courseService=new CourseServiceImpl();
        courseService.setCourseDao(courseDao);
        assertThat(courseService.getCourseCount(),is(courseDao.size()));
    }
}
