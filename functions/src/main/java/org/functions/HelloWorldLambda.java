package org.functions;

import org.functions.model.Employee;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.lambda.powertools.validation.ValidationException;
import software.amazon.lambda.powertools.validation.ValidationUtils;

public class HelloWorldLambda implements RequestHandler<Employee,String>
{
    @Override
    public String handleRequest(Employee name, Context context) {
        LambdaLogger logger= context.getLogger();
        logger.log("Lambda Function Invoked....");
        try {
            //ValidationUtils.validate(name, "classpath:/schema.json");
            return "Good Morning";
        } catch(ValidationException exception) {
            return "Input Not valid: " + exception.getMessage();
        }

    }
}
