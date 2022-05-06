package com.example.ramayan.apptheme;

import com.example.ramayan.R;

public class Method {

    public void setColorTheme(){

        switch (Constant.color){
            case 0xffF44336:
                Constant.theme = R.color.purple_200;
                break;
            case 0xffE91E63:
                Constant.theme = R.color.purple_500;
                break;
            case 0xff9C27B0:
                Constant.theme = R.color.purple_700;
                break;
            case 0xff673AB7:
                Constant.theme = R.color.teal_200;
                break;
            case 0xff3F51B5:
                Constant.theme = R.color.teal_700;
                break;
            case 0xff03A9F4:
                Constant.theme = R.color.teal_200;
                break;
            default:
                Constant.theme = R.color.purple_200;
                break;
        }
    }
}
