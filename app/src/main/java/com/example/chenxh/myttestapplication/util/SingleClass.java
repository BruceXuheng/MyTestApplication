package com.example.chenxh.myttestapplication.util;

public class SingleClass {

//    private static SingleClass instance;
//
//    private SingleClass(){}
//
//    public static SingleClass getInstance(){
//
//        if(instance == null){
//            synchronized (SingleClass.class){
//                if(instance == null){
//                    instance = new SingleClass();
//                }
//            }
//        }
//
//        return instance;
//    }





    private static SingleClass instance;

    private SingleClass(){}

    public static SingleClass getInstance(){
        return SingleClassHolder.INSTANCE;
    }

    private static class SingleClassHolder{

        private static final SingleClass INSTANCE = new SingleClass();

    }


//    private static SingleClass instance;
//
//    private SingleClass(){}
//
//    public static SingleClass getInstance(){
//
//       return SingleClassHolder.INSTANCE;
//
//    }
//    private static class SingleClassHolder {
//
//        private static final SingleClass INSTANCE = new SingleClass();
//
//    }
}