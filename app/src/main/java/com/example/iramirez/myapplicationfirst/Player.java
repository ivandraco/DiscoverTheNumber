package com.example.iramirez.myapplicationfirst;

/**
 * Created by IVANROCK on 25-May-17.
 */

public class Player {

    //private variables
    int _id;
    String _name;
    private int _discover;
    private int _fail;

    // Empty constructor
    public Player(){

    }
    // constructor
    public Player(int id, String name, int _discover, int _fail){
        this._id = id;
        this._name = name;
        this.set_discover(_discover);
        this.set_fail(_fail);
    }

    // constructor
    public Player(String name, int _discover, int _fail){
        this._name = name;
        this.set_discover(_discover);
        this.set_fail(_fail);
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }


    public int get_discover() {
        return _discover;
    }

    public void set_discover(int _discover) {
        this._discover = _discover;
    }

    public int get_fail() {
        return _fail;
    }

    public void set_fail(int _fail) {
        this._fail = _fail;
    }
}
