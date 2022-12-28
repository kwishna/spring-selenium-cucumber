package com.example.model;

public class Response {
    private int n1;
    private int n2;

    public Response(int n1, int n2, int result) {
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", result=" + result +
                '}';
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private int result;
}
