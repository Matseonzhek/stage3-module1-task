package com.mjc.school.repository.source.data;

import com.mjc.school.repository.Utils.Utils;
import com.mjc.school.repository.entity.AuthorModel;

import java.util.List;

public class AuthorData {
    private static List<AuthorModel> authorModelList;
    private static AuthorData authorDataInstance;

    private AuthorData() {
        init();
    }

    public static AuthorData getAuthorDataInstance() {
        if (authorDataInstance ==null){
            authorDataInstance = new AuthorData();
        }
        return authorDataInstance;
    }
    private void init(){
        authorModelList = Utils.readAuthorsFromFile();
    }

    public List<AuthorModel> getAuthorModelList() {
        return authorModelList;
    }
}
