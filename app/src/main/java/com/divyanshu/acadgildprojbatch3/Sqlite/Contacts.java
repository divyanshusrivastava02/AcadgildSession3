package com.divyanshu.acadgildprojbatch3.Sqlite;

/**
 * Created by Divyanshu on 11-07-2016.
 */
public class Contacts {

    int _id;
    String _name;
    String _phone_number;

    public Contacts(){

    }

    public Contacts(String name, String phNumber){
        this._name = name;
        this._phone_number = phNumber;
    }

    public Contacts(int id, String name, String phNumber){

        this._id = id;
        this._name = name;
        this._phone_number = phNumber;
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }


}