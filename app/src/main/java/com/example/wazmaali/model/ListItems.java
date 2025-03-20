package com.example.wazmaali.model;
import com.google.gson.annotations.SerializedName;


public class ListItems {

    @SerializedName("id")
    public Integer id;
    @SerializedName("listId")
    public Integer listId;
    @SerializedName("name")
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
