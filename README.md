# Java Mutation Testing Example

A demonstration on how to verify if tests are correct beyond the usual code coverage and test success metrics.

# How to use

## Prerequisites

* You need Maven3
* You need Java 8


## Running the tests

Use this maven command: ``mvn clean package``

This should generate reports in the following directories:
* Code coverage report: _target/site/jacoco/index.html_
* Mutation test report: _target/pit-reports/index.html_

# What to Observe

Given this business logice:

```java
public class FooClass {
    public static int SUCCESS_CODE = 1;

    public String doBusinessLogic(int someCode) {
        String result = "FAILURE";

        if (someCode == SUCCESS_CODE) {
            result = "SUCCESS";
        }

        return result;
    }
}
```

These tests succeed and give 100% good coverage, but they provide no value:

```java
    @Test
    public void shouldSucceed_WhenGoodCodeGiven() {
        int goodCode = 1;

        String result = this.fooClass.doBusinessLogic(goodCode);
    }

    @Test
    public void shouldFail_WhenWrongCodeGiven() {
        int goodCode = -1;

        String result = this.fooClass.doBusinessLogic(goodCode);
    }
}
```

You can see this in the report, surefire and jacoco give everything green - but - Pitest shows that you have 2 living 
mutations. We need to kill these mutations.

Fixing tests like so helps kill these mutations and proves that the tests have value.

```java
    @Test
    public void shouldSucceed_WhenGoodCodeGiven() {
        int goodCode = 1;

        String result = this.fooClass.doBusinessLogic(goodCode);

        Assert.assertEquals(result, "SUCCESS");
    }

    @Test
    public void shouldFail_WhenWrongCodeGiven() {
        int goodCode = -1;

        String result = this.fooClass.doBusinessLogic(goodCode);

        Assert.assertEquals(result, "FAILURE");
    }
```

PiTest will show green, not living mutations.