package gradecalculation;

import java.util.HashMap;
import java.util.ArrayList;

/*
class: Grade
description:
    take mid-term, final and other marks and generate grade letter and point
*/
/**
 *
 * @author mursalatul
 */


public class Grade {
    private int midTermMark = 0, finalMark = 0, otherMark = 0, totalMark = 0;
    private String gradeLetter = "NULL";
    private float gradePoint = 0f;

    // initializing the marks

    /**
     * Take mid-term mark, final mark, and other marks as input and initialize
     * the object's data for further operations.
     * @param midTermMark
     * @param finalMark
     * @param otherMark
     */
    public void setMark(int midTermMark, int finalMark, int otherMark) {
        this.midTermMark = midTermMark;
        this.finalMark = finalMark;
        this.otherMark = otherMark;
        this.totalMark = midTermMark + finalMark + otherMark;

        // calculating the grade after getting the marks
        calculateGrade();
    }

    // calculate grade
    private void calculateGrade() {
        if (totalMark >= 80) {
            gradeLetter = "A+";
            gradePoint = 4.00f;
        } else if (totalMark >= 75) {
            gradeLetter = "A";
            gradePoint = 3.75f;
        } else if (totalMark >= 70) {
            gradeLetter = "A-";
            gradePoint = 3.50f;
        } else if (totalMark >= 65) {
            gradeLetter = "B+";
            gradePoint = 3.25f;
        } else if (totalMark >= 60) {
            gradeLetter = "B";
            gradePoint = 3.00f;
        } else if (totalMark >= 55) {
            gradeLetter = "B-";
            gradePoint = 2.75f;
        } else if (totalMark >= 50) {
            gradeLetter = "C+";
            gradePoint = 2.50f;
        } else if (totalMark >= 45) {
            gradeLetter = "C";
            gradePoint = 2.25f;
        } else if (totalMark >= 40) {
            gradeLetter = "D";
            gradePoint = 2.00f;
        } else {
            gradeLetter = "F";
            gradePoint = 0.00f;
        }
    }

    // return inputed marks

    /**
     * to check if the inputted data is correct or not,
     * see the inputted all marks.
     * @return HashMap<String, Integer>
     */
    public HashMap<String, Integer> getMark() {
        // creating the hashmap
        HashMap<String, Integer> markDick = new HashMap<String, Integer>();

        // storing marks into the hashmap
        markDick.put("midTermMark", midTermMark);
        markDick.put("finalMark", finalMark);
        markDick.put("otherMark", otherMark);
        markDick.put("totalMark", totalMark);

        return markDick;
    }

    // return grade letter

    /**
     * MUST BE CALLED AFTER setMark() method
     * @return grade letter
     */
    public String gradeLetter() {
        return gradeLetter;
    }

    /**
     * MUST BE CALLED AFTER setMark() method
     * @return grade point
     */
    public float gradePoint() {
        return gradePoint;
    }

    /**
     * 
     * @param gradePoints
     * @return avg grade point off all the grade points
     */
    public float avgGradePoint(ArrayList<Float> gradePoints) {
        int size = gradePoints.size();
        float sum = 0.0f;
        for (float f: gradePoints) {
            sum += f;
        }
        return sum / size;
    }

    /**
     * 
     * @param gradePoints
     * @return avg grade letter off all the grade letter
     */
    public String avgGradeLetter(ArrayList<Float> gradePoints) {
        float avgGradePoint = avgGradePoint(gradePoints);
        if (avgGradePoint >= 4.00f) {
            return "A+";
        } else if (avgGradePoint >= 3.75f) {
            return "A";
        } else if (avgGradePoint >= 3.50f) {
            return "A-";
        } else if (avgGradePoint >= 3.25f) {
            return "B+";
        } else if (avgGradePoint >= 3.00f) {
            return "B";
        } else if (avgGradePoint >= 2.75f) {
            return "B-";
        } else if (avgGradePoint >= 2.50f) {
            return "C+";
        } else if (avgGradePoint >= 2.25f) {
            return "C";
        } else if (avgGradePoint >= 2.00f) {
            return "D";
        } else {
            return "F";
        }
    }
}
