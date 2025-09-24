package edu.ccrm.service;

import java.util.*;

public class TranscriptService {
    // Map: studentId → (courseCode → grade)
    private final Map<String, Map<String, String>> transcripts = new HashMap<>();

    public void recordGrade(String studentId, String courseCode, String grade) {
        transcripts.putIfAbsent(studentId, new HashMap<>());
        transcripts.get(studentId).put(courseCode, grade);
        System.out.println(" Grade recorded: " + studentId + " | " + courseCode + " = " + grade);
    }

    public Map<String, String> getTranscript(String studentId) {
        return transcripts.getOrDefault(studentId, new HashMap<>());
    }

    public void printTranscript(String studentId) {
        Map<String, String> transcript = getTranscript(studentId);
        if (transcript.isEmpty()) {
            System.out.println("️ No transcript found for student " + studentId);
        } else {
            System.out.println(" Transcript for student " + studentId + ":");
            transcript.forEach((course, grade) ->
                    System.out.println("   " + course + " → " + grade));
        }
    }
}