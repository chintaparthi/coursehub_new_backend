package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {
    private String coursename;
    @Id
    private String coursecode;

    @Lob
    private byte[] pdfFile; // To store the PDF as binary data

    @Lob
    private byte[] imageFile; // To store the image as binary data

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public byte[] getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "Courses [coursename=" + coursename + ", coursecode=" + coursecode + "]";
    }
}
