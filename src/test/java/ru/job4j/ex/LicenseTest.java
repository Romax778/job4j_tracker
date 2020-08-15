package ru.job4j.ex;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.pojo.License;

import static org.hamcrest.CoreMatchers.is;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");

        Assert.assertThat(first, is(second));
    }
}
