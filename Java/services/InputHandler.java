package services;

import models.WorkOrder;
import utils.InputHelper;
import utils.ValidationUtil;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    private final ValidationUtil validationUtil;
    private final InputHelper inputHelper;

    public InputHandler(ValidationUtil validationUtil, InputHelper inputHelper) {
        this.validationUtil = validationUtil;
        this.inputHelper = inputHelper;
    }

    public String checkWorkOrderTitle()
    {
        return inputHelper.getValidString("Enter the title: ",
                input -> validationUtil.isNonEmptyString(input)
                        && validationUtil.isAlphanumeric(input),
                "Invalid title, please try again.");
    }

    public String checkDescription() {
        return inputHelper.getValidString("Enter a description for the work order: ",
                input -> validationUtil.isNonEmptyString(input)
                        && validationUtil.isAlphanumeric(input),
                "Invalid description, please try again.");
    }

    public String checkStatus() {
        return inputHelper.getValidStatus("Enter a status, either open, in progress, or closed: ",
                input -> validationUtil.isInList(Arrays.asList("open", "in progress", "closed"), input),
                "invalid input, please try again.");
    }

    public int checkPrio() {
        return inputHelper.getValidPrio("Enter a priority from 1(highest) to 5(lowest): ",
                input -> validationUtil.isInList(Arrays.asList(1,2,3,4,5), input),
                "invalid input.");
    }
}
