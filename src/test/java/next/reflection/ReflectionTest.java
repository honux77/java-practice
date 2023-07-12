package next.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    @DisplayName("테스트1: 리플렉션을 이용해서 클래스와 메소드의 정보를 정확하게 출력해야 한다.")
    //Question 클래스의 모든 필드, 생성자, 메소드에 대한 정보를 출력한다
    public void showClass() {
        SoftAssertions s = new SoftAssertions();
        Class<Question> clazz = Question.class;
        logger.debug("Class Name {}", clazz.getName());

        //print all field info using stream
        logger.debug("필드 정보");
        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
            logger.debug("\t이름: {} 접근한정자: {}", field.getName(), Modifier.toString(field.getModifiers()));
        });

        //print all constructor info using stream
        logger.debug("생성자 정보");
        Arrays.stream(clazz.getDeclaredConstructors()).forEach(constructor -> {
            logger.debug("\t이름: {} 접근한정자: {}", constructor.getName(), Modifier.toString(constructor.getModifiers()));
        });

        //print all method info using stream
        logger.debug("메소드 정보");
        Arrays.stream(clazz.getDeclaredMethods()).forEach(method -> {
            logger.debug("\t이름: {} 접근한정자: {}", method.getName(),
                    Modifier.toString(method.getModifiers()));
        });


    }

    @Test
    public void constructor() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("paramer length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }
}
