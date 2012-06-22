package com.soebes.tools;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import com.soebes.tools.core.CalculateDelta;

public class CalculateDeltaTest {

    @Test
    public void deltaInMilliSecondsTest() {
	CalculateDelta calculate = new CalculateDelta();
	String startDate = "23.03.2010 13:10:00";
	String endDate = "23.03.2010 14:00:00";
	long delta = calculate.deltaInMilliSeconds(startDate, endDate);
	assertThat(delta).isEqualTo(3000000);
    }

    @Test
    public void deltaInSecondsTest() {
	CalculateDelta calculate = new CalculateDelta();
	String startDate = "23.03.2010 13:10:00";
	String endDate = "23.03.2010 14:00:00";
	long delta = calculate.deltaInSeconds(startDate, endDate);
	assertThat(delta).isEqualTo(3000);
    }
}
