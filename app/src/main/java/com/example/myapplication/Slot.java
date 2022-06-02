package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Slot extends AppCompatActivity implements View.OnClickListener
{
    ImageView imgTopBg, imgCenterBg, imgBottomBg;
    ImageView imgReelsBg, imgReelsBorder;
    ImageView imgBottomPanel;
    ImageView imgReel1x1,imgReel1x2,imgReel1x3;
    ImageView imgReel2x1,imgReel2x2,imgReel2x3;
    ImageView imgReel3x1,imgReel3x2,imgReel3x3;
    ImageView imgReel4x1,imgReel4x2,imgReel4x3;
    ImageView imgReel5x1,imgReel5x2,imgReel5x3;

    ImageView imgReel1x4,imgReel1x5,imgReel1x6;
    ImageView imgReel2x4,imgReel2x5,imgReel2x6;
    ImageView imgReel3x4,imgReel3x5,imgReel3x6;
    ImageView imgReel4x4,imgReel4x5,imgReel4x6;
    ImageView imgReel5x4,imgReel5x5,imgReel5x6;

    ImageView imgAnim1x1,imgAnim1x2,imgAnim1x3;
    ImageView imgAnim2x1,imgAnim2x2,imgAnim2x3;
    ImageView imgAnim3x1,imgAnim3x2,imgAnim3x3;
    ImageView imgAnim4x1,imgAnim4x2,imgAnim4x3;
    ImageView imgAnim5x1,imgAnim5x2,imgAnim5x3;

    ImageView imgLines;

    ImageView imgInfo;

    Button butLeft, butRight;
    Button butBetMinus, butBetPlus;
    Button butLineMinus, butLinePlus;

    AppCompatTextView txtCredits;
    AppCompatTextView txtBet;
    AppCompatTextView txtTotalBet;
    AppCompatTextView txtLine;
    AppCompatTextView txtWin;

    Animation animReel1In,animReel1Out;
    Animation animReel2In,animReel2Out;
    Animation animReel3In,animReel3Out;
    Animation animReel4In,animReel4Out;
    Animation animReel5In,animReel5Out;

    Animation animIcons, animTrxt;

    ViewSwitcher swchReel1,swchReel2,swchReel3,swchReel4,swchReel5;

    Handler handReel1,handReel2,handReel3,handReel4,handReel5;

    boolean boolBetPlus;
    boolean boolLinePlus;
    boolean boolSpinReels;

    int intSpinReel1,intSpinReel2,intSpinReel3,intSpinReel4,intSpinReel5;

    int intInfo;

    int intIcons;

    int intIcon1x1, intIcon1x2,intIcon1x3;
    int intIcon2x1, intIcon2x2,intIcon2x3;
    int intIcon3x1, intIcon3x2,intIcon3x3;
    int intIcon4x1, intIcon4x2,intIcon4x3;
    int intIcon5x1, intIcon5x2,intIcon5x3;

    int intCountIcon, intNumberIcon, intWinLine;
    int intCountScatter;

    int CREDIT = 0;
    int BET = 1;
    int LINE = 1;
    int TOTALBET;
    int WIN;


    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slot);

        imgTopBg = findViewById(R.id.imageTopBg);
        imgCenterBg = findViewById(R.id.imageCenterBg);
        imgBottomBg = findViewById(R.id.imageBottomBg);

        imgReelsBg = findViewById(R.id.imageReelsBg);
        imgReelsBorder = findViewById(R.id.imageReelsBorder);

        imgBottomPanel = findViewById(R.id.imageBottomPanel);

        imgReel1x1 = findViewById(R.id.imageReel1x1);
        imgReel1x2 = findViewById(R.id.imageReel1x2);
        imgReel1x3 = findViewById(R.id.imageReel1x3);
        imgReel2x1 = findViewById(R.id.imageReel2x1);
        imgReel2x2 = findViewById(R.id.imageReel2x2);
        imgReel2x3 = findViewById(R.id.imageReel2x3);
        imgReel3x1 = findViewById(R.id.imageReel3x1);
        imgReel3x2 = findViewById(R.id.imageReel3x2);
        imgReel3x3 = findViewById(R.id.imageReel3x3);
        imgReel4x1 = findViewById(R.id.imageReel4x1);
        imgReel4x2 = findViewById(R.id.imageReel4x2);
        imgReel4x3 = findViewById(R.id.imageReel4x3);
        imgReel5x1 = findViewById(R.id.imageReel5x1);
        imgReel5x2 = findViewById(R.id.imageReel5x2);
        imgReel5x3 = findViewById(R.id.imageReel5x3);

        imgReel1x4 = findViewById(R.id.imageReel1x4);
        imgReel1x5 = findViewById(R.id.imageReel1x5);
        imgReel1x6 = findViewById(R.id.imageReel1x6);
        imgReel2x4 = findViewById(R.id.imageReel2x4);
        imgReel2x5 = findViewById(R.id.imageReel2x5);
        imgReel2x6 = findViewById(R.id.imageReel2x6);
        imgReel3x4 = findViewById(R.id.imageReel3x4);
        imgReel3x5 = findViewById(R.id.imageReel3x5);
        imgReel3x6 = findViewById(R.id.imageReel3x6);
        imgReel4x4 = findViewById(R.id.imageReel4x4);
        imgReel4x5 = findViewById(R.id.imageReel4x5);
        imgReel4x6 = findViewById(R.id.imageReel4x6);
        imgReel5x4 = findViewById(R.id.imageReel5x4);
        imgReel5x5 = findViewById(R.id.imageReel5x5);
        imgReel5x6 = findViewById(R.id.imageReel5x6);

        imgAnim1x1 = findViewById(R.id.imageAnim1x1);
        imgAnim1x2 = findViewById(R.id.imageAnim1x2);
        imgAnim1x3 = findViewById(R.id.imageAnim1x3);
        imgAnim2x1 = findViewById(R.id.imageAnim2x1);
        imgAnim2x2 = findViewById(R.id.imageAnim2x2);
        imgAnim2x3 = findViewById(R.id.imageAnim2x3);
        imgAnim3x1 = findViewById(R.id.imageAnim3x1);
        imgAnim3x2 = findViewById(R.id.imageAnim3x2);
        imgAnim3x3 = findViewById(R.id.imageAnim3x3);
        imgAnim4x1 = findViewById(R.id.imageAnim4x1);
        imgAnim4x2 = findViewById(R.id.imageAnim4x2);
        imgAnim4x3 = findViewById(R.id.imageAnim4x3);
        imgAnim5x1 = findViewById(R.id.imageAnim5x1);
        imgAnim5x2 = findViewById(R.id.imageAnim5x2);
        imgAnim5x3 = findViewById(R.id.imageAnim5x3);


        imgLines = findViewById(R.id.imageLines);

        imgInfo = findViewById(R.id.imageInfo);

        butLeft = findViewById(R.id.buttonLeft);
        butLeft.setOnClickListener(this);
        butLeft.setSoundEffectsEnabled(false);
        butRight = findViewById(R.id.buttonRight);
        butRight.setOnClickListener(this);
        butRight.setSoundEffectsEnabled(false);

        butBetMinus = findViewById(R.id.buttonBetMinus);
        butBetMinus.setOnClickListener(this);
        butBetMinus.setSoundEffectsEnabled(false);
        butBetPlus = findViewById(R.id.buttonBetPlus);
        butBetPlus.setOnClickListener(this);
        butBetPlus.setSoundEffectsEnabled(false);

        butLineMinus = findViewById(R.id.buttonLineMinus);
        butLineMinus.setOnClickListener(this);
        butLineMinus.setSoundEffectsEnabled(false);
        butLinePlus = findViewById(R.id.buttonLinePlus);
        butLinePlus.setOnClickListener(this);
        butLinePlus.setSoundEffectsEnabled(false);

        txtCredits = findViewById(R.id.textCredit);
        txtBet = findViewById(R.id.textBet);
        txtTotalBet = findViewById(R.id.textTotalBet);
        txtLine = findViewById(R.id.textLine);
        txtWin = findViewById(R.id.textWin);

        animReel1In= AnimationUtils.loadAnimation(this,R.anim.a_reel_in);
        animReel1Out= AnimationUtils.loadAnimation(this,R.anim.a_reel_out);
        animReel2In= AnimationUtils.loadAnimation(this,R.anim.a_reel_in);
        animReel2Out= AnimationUtils.loadAnimation(this,R.anim.a_reel_out);
        animReel3In= AnimationUtils.loadAnimation(this,R.anim.a_reel_in);
        animReel3Out= AnimationUtils.loadAnimation(this,R.anim.a_reel_out);
        animReel4In= AnimationUtils.loadAnimation(this,R.anim.a_reel_in);
        animReel4Out= AnimationUtils.loadAnimation(this,R.anim.a_reel_out);
        animReel5In= AnimationUtils.loadAnimation(this,R.anim.a_reel_in);
        animReel5Out= AnimationUtils.loadAnimation(this,R.anim.a_reel_out);

        animIcons = AnimationUtils.loadAnimation(this,R.anim.a_icons);
        animTrxt = AnimationUtils.loadAnimation(this,R.anim.a_text);

        swchReel1 = findViewById(R.id.switcherReel1);
        swchReel2 = findViewById(R.id.switcherReel2);
        swchReel3 = findViewById(R.id.switcherReel3);
        swchReel4 = findViewById(R.id.switcherReel4);
        swchReel5 = findViewById(R.id.switcherReel5);

        SlotStart();
    }
    public void SlotStart()
    {
            imgTopBg.setBackground(getAssetJpg(this,"slot_top"));

        imgCenterBg.setBackground(getAssetJpg(this,"slot_center"));
        imgBottomBg.setBackground(getAssetJpg(this,"slot_bottom"));

        imgBottomPanel.setBackground(getAssetJpg(this,"bottom_panel"));

        butLeft.setBackground(getAssetJpg(this,"button_info_1"));
        butRight.setBackground(getAssetJpg(this,"button_spin_1"));


        imgReel1x1.setBackground(getAssetJpg(this,"icone_1"));
        imgReel1x2.setBackground(getAssetJpg(this,"icone_3"));
        imgReel1x3.setBackground(getAssetJpg(this,"icone_5"));
        imgReel2x1.setBackground(getAssetJpg(this,"icone_2"));
        imgReel2x2.setBackground(getAssetJpg(this,"icone_7"));
        imgReel2x3.setBackground(getAssetJpg(this,"icone_6"));
        imgReel3x1.setBackground(getAssetJpg(this,"icone_3"));
        imgReel3x2.setBackground(getAssetJpg(this,"icone_7"));
        imgReel3x3.setBackground(getAssetJpg(this,"icone_5"));
        imgReel4x1.setBackground(getAssetJpg(this,"icone_2"));
        imgReel4x2.setBackground(getAssetJpg(this,"icone_7"));
        imgReel4x3.setBackground(getAssetJpg(this,"icone_5"));
        imgReel5x1.setBackground(getAssetJpg(this,"icone_1"));
        imgReel5x2.setBackground(getAssetJpg(this,"icone_3"));
        imgReel5x3.setBackground(getAssetJpg(this,"icone_5"));

        imgReel1x4.setBackground(getAssetJpg(this,"icone_1"));
        imgReel1x5.setBackground(getAssetJpg(this,"icone_3"));
        imgReel1x6.setBackground(getAssetJpg(this,"icone_5"));
        imgReel2x4.setBackground(getAssetJpg(this,"icone_2"));
        imgReel2x5.setBackground(getAssetJpg(this,"icone_7"));
        imgReel2x6.setBackground(getAssetJpg(this,"icone_6"));
        imgReel3x4.setBackground(getAssetJpg(this,"icone_3"));
        imgReel3x5.setBackground(getAssetJpg(this,"icone_7"));
        imgReel3x6.setBackground(getAssetJpg(this,"icone_5"));
        imgReel4x4.setBackground(getAssetJpg(this,"icone_2"));
        imgReel4x5.setBackground(getAssetJpg(this,"icone_7"));
        imgReel4x6.setBackground(getAssetJpg(this,"icone_5"));
        imgReel5x4.setBackground(getAssetJpg(this,"icone_1"));
        imgReel5x5.setBackground(getAssetJpg(this,"icone_3"));
        imgReel5x6.setBackground(getAssetJpg(this,"icone_5"));

        ShowCredits();
        ShowBet();
        ShowTotalBet();
        ShowLines();
        ShowWin();

        CheckBet();
        CheckLine();
        ShowButtons();

    }
    @Override
    public void onClick(View v)
    {
        int button = v.getId();
        if(button==R.id.buttonLeft)
        {
            if(intInfo==0 && !boolSpinReels && WIN ==0) ShowInfo();
            else if(intInfo==2) CloseInfo();
        }
        if(button == R.id.buttonBetMinus)
        {
            if(BET != 1 && intInfo==0 && !boolSpinReels && WIN ==0)
            {
                if(CREDIT >= TOTALBET) boolBetPlus=true;
                if(BET == 100) BET=50;
                else  if(BET == 50) BET=40;
                else  if(BET == 40) BET=30;
                else  if(BET == 30) BET=20;
                else  if(BET == 20) BET=15;
                else  if(BET == 15) BET=10;
                else   if(BET == 10) BET=5;
                else   if(BET == 5) BET=4;
                else  if(BET == 4) BET=3;
                else  if(BET == 3) BET=2;
                else  if(BET == 2) BET=1;

                ShowBet();
                ShowTotalBet();
                CheckBet();
                CheckLine();
                ShowButtons();
            }
        }
        if(button == R.id.buttonBetPlus)
        {
            if(boolBetPlus && intInfo==0 && !boolSpinReels && WIN ==0)
            {
                if(BET == 1) BET = 2;
                else if(BET == 2) BET = 3;
                else if(BET == 3) BET=4;
                else if(BET == 4) BET=5;
                else if(BET == 5) BET=10;
                else if(BET == 10) BET=15;
                else if(BET == 15) BET=20;
                else if(BET == 20) BET=30;
                else if(BET == 30) BET=40;
                else if(BET == 40) BET=50;
                else if(BET == 50) BET=100;

                ShowBet();
                ShowTotalBet();
                CheckBet();
                CheckLine();
                ShowButtons();
            }
        }
        if(button == R.id.buttonLineMinus)
        {
            if(LINE != 1 && intInfo==0 && !boolSpinReels && WIN ==0)
            {
                if(CREDIT >= TOTALBET) boolLinePlus=true;
                if(LINE == 5) BET=4;
                else  if(LINE == 4) BET=3;
                else  if(LINE == 3) BET=2;
                else  if(LINE == 2) BET=1;

                loadLines();
                ShowLines();
                ShowTotalBet();
                CheckBet();
                CheckLine();
                ShowButtons();
            }
        }
        if(button == R.id.buttonLinePlus)
        {
            if(boolLinePlus && intInfo==0 && !boolSpinReels && WIN ==0)
            {
                if(LINE == 1) BET=2;
                else  if(LINE == 2) BET=3;
                else  if(LINE == 3) BET=4;
                else  if(LINE == 4) BET=5;

                loadLines();
                ShowLines();
                ShowTotalBet();
                CheckBet();
                CheckLine();
                ShowButtons();
            }
        }
        if(button == R.id.buttonRight)
        {
            if (!boolSpinReels && intInfo==0 && !boolSpinReels)
            {
                if(imgLines!=null) imgLines.setBackground(null);
                if(WIN > 0)
                {
                    CREDIT = CREDIT +WIN;
                    ShowCredits();
                    WIN = 0;
                    ShowWin();
                    CheckBet();
                    CheckLine();

                    if(CREDIT<TOTALBET) CheckCredits();
                }
                else
                {
                    boolSpinReels = true;
                    CREDIT = CREDIT - TOTALBET;
                    ShowCredits();
                    SpinReels();
                }
                ShowButtons();
            }
        }
    }

    public void ShowButtons()
    {
        if(!boolSpinReels && WIN ==0)
            butLeft.setBackground(getAssetPng(this,"button_info_1"));
        else
            butLeft.setBackground(getAssetPng(this,"button_info_0"));
        if(BET != 1 && intInfo==0 && !boolSpinReels && WIN ==0)
            butBetMinus.setBackground(getAssetPng(this,"button_minus_1"));
        else
            butBetMinus.setBackground(getAssetPng(this,"button_minus_0"));
        if(boolBetPlus && intInfo==0 && !boolSpinReels && WIN ==0)
            butBetMinus.setBackground(getAssetPng(this,"button_plus_1"));
        else
            butBetMinus.setBackground(getAssetPng(this,"button_plus_0"));
        if(LINE != 1 && intInfo==0 && !boolSpinReels && WIN ==0)
            butLineMinus.setBackground(getAssetPng(this,"button_minus_1"));
        else
            butLineMinus.setBackground(getAssetPng(this,"button_minus_0"));
        if(boolLinePlus && intInfo==0 && !boolSpinReels && WIN ==0)
        butLinePlus.setBackground(getAssetPng(this,"button_plus_1"));
        else
            butLinePlus.setBackground(getAssetPng(this,"button_plus_0"));
        if(!boolSpinReels && intInfo==0)
        {
            if(WIN > 0)
                butRight.setBackground(getAssetPng(this,"button_take_1"));
            else
                butRight.setBackground(getAssetPng(this,"button_spin_1"));
        }
        else
            butRight.setBackground(getAssetPng(this,"button_spin_0"));
    }

    public void ShowInfo()
    {
        intInfo=1;
        Animation animInfoOut = AnimationUtils.loadAnimation(this,R.anim.a_info_out);
        animInfoOut.setDuration(300);
        imgInfo.setAnimation(animInfoOut);
        imgInfo.startAnimation(animInfoOut);
        butLeft.setBackground(getAssetPng(this,"button_close_0"));

        Handler InfoShow = new Handler();
        InfoShow.postDelayed(()->
        {
            intInfo=0;
            butLeft.setBackground(getAssetPng(this,"button_info_1"));
            imgInfo.setAnimation(null);
            ShowButtons();
        },400);
    }

    public void CloseInfo()
    {
        intInfo=1;
        Animation animInfoIn = AnimationUtils.loadAnimation(this,R.anim.a_info_in);
        animInfoIn.setDuration(300);
        imgInfo.setAnimation(animInfoIn);
        imgInfo.setBackground(getAssetPng(this,"info_paytable"));
        ShowButtons();
        butLeft.setBackground(getAssetPng(this,"button_info_0"));

        Handler InfoShow = new Handler();
        InfoShow.postDelayed(()->
        {
            intInfo=2;
            butLeft.setBackground(getAssetPng(this,"button_close_1"));
            imgInfo.setAnimation(null);
        },400);
    }

    public void CheckCredits()
    {
        if(CREDIT >= LINE *50) BET=50;
        else if(CREDIT >= LINE *40) BET=40;
        else if(CREDIT >= LINE *30) BET=30;
        else if(CREDIT >= LINE *20) BET=20;
        else if(CREDIT >= LINE *15) BET=15;
        else if(CREDIT >= LINE *10) BET=10;
        else if(CREDIT >= LINE *5) BET=5;
        else if(CREDIT >= LINE *4) BET=4;
        else if(CREDIT >= LINE *3) BET=3;
        else if(CREDIT >= LINE *2) BET=2;
        else if(CREDIT >= LINE) BET=1;
        else
        {
            BET = 1;
            LINE = CREDIT;
            boolLinePlus= false;
        }
        if(CREDIT == 0)
        {
            BET = 0;
            LINE = 0;
            boolSpinReels = true;
        }
        else
            boolBetPlus = false;

        ShowBet();
        ShowLines();
        ShowTotalBet();
    }

    public void ShowCredits()
    {
        String strCredits =""+ CREDIT;
        txtCredits.setText(strCredits);
    }
    public void  ShowBet()
    {
        String strBet =""+ BET;
        txtBet.setText(strBet);
    }
    public void  CheckBet()
    {
        if(BET == 1) boolBetPlus = CREDIT >= LINE *2;
        else if(BET == 2) boolBetPlus = CREDIT >= LINE *3;
        else  if(BET == 3) boolBetPlus = CREDIT >= LINE *4;
        else if(BET == 4) boolBetPlus = CREDIT >= LINE *5;
        else  if(BET == 5) boolBetPlus = CREDIT >= LINE *10;
        else  if(BET == 10) boolBetPlus = CREDIT >= LINE *15;
        else if(BET == 15) boolBetPlus = CREDIT >= LINE *20;
        else if(BET == 20) boolBetPlus = CREDIT >= LINE *30;
        else  if(BET == 30) boolBetPlus = CREDIT >= LINE *40;
        else if(BET == 40) boolBetPlus = CREDIT >= LINE *50;
        else if(BET == 50) boolBetPlus = CREDIT >= LINE *100;
        else if(BET == 100) boolBetPlus = false;
    }
    public void ShowTotalBet()
    {
        TOTALBET = BET * LINE;
        String strTotalBet = "" + TOTALBET;
        txtTotalBet.setText(strTotalBet);
    }
    public void ShowLines()
    {
        String strline = "" + LINE;
        txtLine.setText(strline);
    }
    public void CheckLine()
    {
        if(LINE == 1) boolLinePlus = CREDIT >= BET *2;
        else if(LINE == 2) boolLinePlus = CREDIT >= BET *3;
        else  if(LINE == 3) boolLinePlus = CREDIT >= BET *4;
        else  if(LINE == 4) boolLinePlus = CREDIT >= BET *5;
        else boolLinePlus = false;
    }
    public void loadLines()
    {
        if(LINE == 1)
            imgLines.setBackground(getAssetPng(this,"line_1"));
        else if(LINE == 2)
            imgLines.setBackground(getAssetPng(this,"line_2"));
        else if(LINE == 3)
            imgLines.setBackground(getAssetPng(this,"line_3"));
        else if(LINE == 4)
            imgLines.setBackground(getAssetPng(this,"line_4"));
        else if(LINE == 5)
            imgLines.setBackground(getAssetPng(this,"line_5"));
    }
    public void ShowWin()
    {
        if(intCountIcon == 2)
            intWinLine = BET * 5;
        else if (intCountIcon == 3)
        {
            if(intNumberIcon == 1 || intNumberIcon == 2)
                intWinLine = BET*20;
            else if(intNumberIcon == 3 || intNumberIcon == 4)
                intWinLine = BET * 30;
            else if(intNumberIcon == 5 || intNumberIcon == 6)
                intWinLine = BET * 50;
            else if(intNumberIcon == 7)
                intWinLine = BET * 100;
        }
        else if(intCountIcon==4)
        {
            if(intNumberIcon == 1 || intNumberIcon == 2)
                intWinLine = BET*50;
            else if(intNumberIcon == 3 || intNumberIcon == 4)
                intWinLine = BET * 75;
            else if(intNumberIcon == 5 || intNumberIcon == 6)
                intWinLine = BET * 200;
            else if(intNumberIcon == 7)
                intWinLine = BET * 1000;
        }
        else if(intCountIcon==5)
        {
            if(intNumberIcon == 1 || intNumberIcon == 2)
                intWinLine = BET*200;
            else if(intNumberIcon == 3 || intNumberIcon == 4)
                intWinLine = BET * 300;
            else if(intNumberIcon == 5 || intNumberIcon == 6)
                intWinLine = BET * 500;
            else if(intNumberIcon == 7)
                intWinLine = BET * 5000;
        }
        else
            intWinLine=0;

            WIN=WIN+intWinLine;
            String strWin = ""+ WIN;
            txtWin.setText(strWin);
            txtWin.setAnimation(animTrxt);

    }

    public void SpinReels ()
    {
        intCountScatter=0;
        intSpinReel1 = 0;

        handReel1 = new Handler();
        swchReel1.setOutAnimation(animReel1Out);
        swchReel1.setOutAnimation(animReel1In);
        animReel1Out.setDuration(200);
        animReel1In.setDuration(200);
        SpinReel1First();

        intSpinReel2 = 0;
        handReel2 = new Handler();
        swchReel2.setOutAnimation(animReel2Out);
        swchReel2.setOutAnimation(animReel2In);
        animReel2Out.setDuration(200);
        animReel2In.setDuration(200);
        SpinReel2First();

        intSpinReel3 = 0;
        handReel3 = new Handler();
        swchReel3.setOutAnimation(animReel3Out);
        swchReel3.setOutAnimation(animReel3In);
        animReel3Out.setDuration(200);
        animReel3In.setDuration(200);
        SpinReel3First();

        intSpinReel4 = 0;
        handReel4 = new Handler();
        swchReel4.setOutAnimation(animReel4Out);
        swchReel4.setOutAnimation(animReel4In);
        animReel4Out.setDuration(200);
        animReel4In.setDuration(200);
        SpinReel4First();

        intSpinReel5 = 0;
        handReel5 = new Handler();
        swchReel5.setOutAnimation(animReel5Out);
        swchReel5.setOutAnimation(animReel5In);
        animReel5Out.setDuration(200);
        animReel5In.setDuration(200);
        SpinReel5First();
    }

    public void RandomIcons()
    {
        int random = (int) (Math.random()*18)+1;

        if (random <=4) intIcons =1;
        else if(random <= 8) intIcons =2;
        else if(random <= 11) intIcons =3;
        else if(random <= 13) intIcons =4;
        else if(random <= 15) intIcons =5;
        else if(random <= 17) intIcons =6;
        else if(random <= 18) intIcons =7;
    }

    public void RandomScatter()
    {
        int random = (int) (Math.random()*8)+1;

        if (random <=1) intIcons =1;
        else if(random <= 2) intIcons =2;
        else if(random <= 3) intIcons =3;
        else if(random <= 4) intIcons =4;
        else if(random <= 5) intIcons =5;
        else if(random <= 6) intIcons =6;
        else if(random <= 7) intIcons =7;
        else intIcons =8;
    }

    public void SpinReel1First()
    {
        intSpinReel1 = intSpinReel1 +1;
        swchReel1.showNext();
        handReel1.postDelayed(()->
        {
            if(intSpinReel1==4) SpinReel1Stop();
            else SpinReel1Second();
        },200);
    }

    public void SpinReel1Second()
    {
        swchReel1.showPrevious();
        handReel1.postDelayed(this::SpinReel1First,200);
    }
    public void SpinReel1Stop()
    {
        RandomScatter();
        intIcon1x3 = intIcons;
        imgReel1x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));

        if(intIcon1x3==8) RandomIcons();
        else RandomScatter();
        intIcon1x2 = intIcons;
        imgReel1x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));

        if(intIcon1x2==8 || intIcon1x3==8) RandomIcons();
        else RandomScatter();
        intIcon1x1=intIcons;
        imgReel1x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));

        if(intIcon1x1 == 8 || intIcon1x2 == 8 || intIcon1x3 == 8)
            intCountScatter= intCountScatter+1;

        animReel1Out.setDuration(400);
        animReel1In.setDuration(400);
        swchReel1.showPrevious();
    }

    public void SpinReel2First()
    {
        intSpinReel2 = intSpinReel2 +1;
        swchReel2.showNext();
        handReel2.postDelayed(()->
        {
            if(intSpinReel2==5) SpinReel2Stop();
            else SpinReel2Second();
        },200);
    }

    public void SpinReel2Second()
    {
        swchReel2.showPrevious();
        handReel2.postDelayed(this::SpinReel2First,200);
    }
    public void SpinReel2Stop()
    {
        RandomScatter();
        intIcon2x3 = intIcons;
        imgReel2x3.setBackground(getAssetJpg(this,"icon_"+intIcon2x3));

        if(intIcon2x3==8) RandomIcons();
        else RandomScatter();
        intIcon2x2 = intIcons;
        imgReel2x2.setBackground(getAssetJpg(this,"icon_"+intIcon2x2));

        if(intIcon2x2==8 || intIcon2x3==8) RandomIcons();
        else RandomScatter();
        intIcon2x1=intIcons;
        imgReel2x1.setBackground(getAssetJpg(this,"icon_"+intIcon2x1));

        if(intIcon2x1 == 8 || intIcon2x2 == 8 || intIcon2x3 == 8)
            intCountScatter= intCountScatter+1;

        animReel2Out.setDuration(400);
        animReel2In.setDuration(400);
        swchReel2.showPrevious();
    }

    public void SpinReel3First()
    {
        intSpinReel3 = intSpinReel3 +1;
        swchReel3.showNext();
        handReel3.postDelayed(()->
        {
            if(intSpinReel3==6) SpinReel3Stop();
            else SpinReel3Second();
        },200);
    }

    public void SpinReel3Second()
    {
        swchReel3.showPrevious();
        handReel3.postDelayed(this::SpinReel3First,200);
    }
    public void SpinReel3Stop()
    {
        RandomScatter();
        intIcon3x3 = intIcons;
        imgReel3x3.setBackground(getAssetJpg(this,"icon_"+intIcon3x3));

        if(intIcon3x3==8) RandomIcons();
        else RandomScatter();
        intIcon3x2 = intIcons;
        imgReel3x2.setBackground(getAssetJpg(this,"icon_"+intIcon3x2));

        if(intIcon3x2==8 || intIcon3x3==8) RandomIcons();
        else RandomScatter();
        intIcon3x1=intIcons;
        imgReel3x1.setBackground(getAssetJpg(this,"icon_"+intIcon3x1));

        if(intIcon3x1 == 8 || intIcon3x2 == 8 || intIcon3x3 == 8)
            intCountScatter= intCountScatter+1;

        animReel3Out.setDuration(400);
        animReel3In.setDuration(400);
        swchReel3.showPrevious();
    }

    public void SpinReel4First()
    {
        intSpinReel4 = intSpinReel4 +1;
        swchReel4.showNext();
        handReel4.postDelayed(()->
        {
            if(intSpinReel4==7) SpinReel4Stop();
            else SpinReel4Second();
        },200);
    }

    public void SpinReel4Second()
    {
        swchReel4.showPrevious();
        handReel4.postDelayed(this::SpinReel4First,200);
    }
    public void SpinReel4Stop()
    {
        RandomScatter();
        intIcon4x3 = intIcons;
        imgReel4x3.setBackground(getAssetJpg(this,"icon_"+intIcon4x3));

        if(intIcon4x3==8) RandomIcons();
        else RandomScatter();
        intIcon4x2 = intIcons;
        imgReel4x2.setBackground(getAssetJpg(this,"icon_"+intIcon4x2));

        if(intIcon4x2==8 || intIcon4x3==8) RandomIcons();
        else RandomScatter();
        intIcon4x1=intIcons;
        imgReel4x1.setBackground(getAssetJpg(this,"icon_"+intIcon4x1));

        if(intIcon4x1 == 8 || intIcon4x2 == 8 || intIcon4x3 == 8)
            intCountScatter= intCountScatter+1;

        animReel4Out.setDuration(400);
        animReel4In.setDuration(400);
        swchReel4.showPrevious();
    }
    public void SpinReel5First()
    {
        intSpinReel5 = intSpinReel5 +1;
        swchReel5.showNext();
        handReel5.postDelayed(()->
        {
            if(intSpinReel5==8) SpinReel5Stop();
            else SpinReel5Second();
        },200);
    }

    public void SpinReel5Second()
    {
        swchReel5.showPrevious();
        handReel5.postDelayed(this::SpinReel5First,200);
    }
    public void SpinReel5Stop()
    {
        RandomScatter();
        intIcon5x3 = intIcons;
        imgReel5x3.setBackground(getAssetJpg(this,"icon_"+intIcon5x3));

        if(intIcon5x3==8) RandomIcons();
        else RandomScatter();
        intIcon5x2 = intIcons;
        imgReel5x2.setBackground(getAssetJpg(this,"icon_"+intIcon5x2));

        if(intIcon5x2==8 || intIcon5x3==8) RandomIcons();
        else RandomScatter();
        intIcon5x1=intIcons;
        imgReel5x1.setBackground(getAssetJpg(this,"icon_"+intIcon5x1));

        if(intIcon5x1 == 8 || intIcon5x2 == 8 || intIcon5x3 == 8)
            intCountScatter= intCountScatter+1;

        animReel5Out.setDuration(400);
        animReel5In.setDuration(400);
        swchReel5.showPrevious();

        handReel5.postDelayed(this::StopReels,400);
    }
    public void StopReels()
    {
        handReel1.removeCallbacksAndMessages(null);
        handReel2.removeCallbacksAndMessages(null);
        handReel3.removeCallbacksAndMessages(null);
        handReel4.removeCallbacksAndMessages(null);
        handReel5.removeCallbacksAndMessages(null);

        swchReel1.setOutAnimation(null);
        swchReel2.setOutAnimation(null);
        swchReel3.setOutAnimation(null);
        swchReel4.setOutAnimation(null);
        swchReel5.setOutAnimation(null);

        swchReel1.setInAnimation(null);
        swchReel2.setInAnimation(null);
        swchReel3.setInAnimation(null);
        swchReel4.setInAnimation(null);
        swchReel5.setInAnimation(null);

        LoadLine1();
    }
    public void LoadLine1()
    {
        if(intIcon1x2 != 8 && intIcon1x2 == intIcon2x2)
        {
            if(intIcon1x2 == intIcon3x2)
            {
                if(intIcon1x2 == intIcon4x2)
                {
                    if(intIcon1x2 == intIcon5x2) intCountIcon=5;
                    else
                        intCountIcon=4;
                }
                else
                    intCountIcon=3;
            }
            else if(intIcon1x2 == 1) intCountIcon=2;
        }
        if(intCountIcon >= 2)
        {
            intNumberIcon = intIcon1x2;
            imgAnim1x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));
            imgAnim1x2.setImageResource(R.drawable.b_line_1);
            imgAnim1x2.startAnimation(animIcons);
            imgAnim2x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));
            imgAnim2x2.setImageResource(R.drawable.b_line_1);
            imgAnim2x2.startAnimation(animIcons);
            if(intCountIcon>=3)
            {
                imgAnim3x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));
                imgAnim3x2.setImageResource(R.drawable.b_line_1);
                imgAnim3x2.startAnimation(animIcons);
            }
            if(intCountIcon>=4)
            {
                imgAnim4x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));
                imgAnim4x2.setImageResource(R.drawable.b_line_1);
                imgAnim4x2.startAnimation(animIcons);
            }
            if(intCountIcon>=5)
            {
                imgAnim5x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x2));
                imgAnim5x2.setImageResource(R.drawable.b_line_1);
                imgAnim5x2.startAnimation(animIcons);
            }

            imgLines.setBackground(getAssetPng(this,"line_1"));
            ShowWin();
            Handler Line1= new Handler();
            Line1.postDelayed(this::LoadLine2,1000);
        }
        else
            LoadLine2();
    }

    public void LoadLine2()
    {
        ClearAnim();
        if(intIcon1x1 != 8 && intIcon1x1 == intIcon2x1 && LINE >= 2)
        {
            if(intIcon1x1 == intIcon3x1)
            {
                if(intIcon1x1 == intIcon4x1)
                {
                    if(intIcon1x1 == intIcon5x1) intCountIcon=5;
                    else
                        intCountIcon=4;
                }
                else
                    intCountIcon=3;
            }
            else if(intIcon1x2 == 1) intCountIcon=2;
        }
        if(intCountIcon >= 2)
        {
            intNumberIcon = intIcon1x1;
            imgAnim1x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
            imgAnim1x1.setImageResource(R.drawable.b_line_2);
            imgAnim1x1.startAnimation(animIcons);
            imgAnim2x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
            imgAnim2x1.setImageResource(R.drawable.b_line_2);
            imgAnim2x1.startAnimation(animIcons);
            if(intCountIcon>=3)
            {
                imgAnim3x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim3x1.setImageResource(R.drawable.b_line_2);
                imgAnim3x1.startAnimation(animIcons);
            }
            if(intCountIcon>=4)
            {
                imgAnim4x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim4x1.setImageResource(R.drawable.b_line_2);
                imgAnim4x1.startAnimation(animIcons);
            }
            if(intCountIcon>=5)
            {
                imgAnim5x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim5x1.setImageResource(R.drawable.b_line_2);
                imgAnim5x1.startAnimation(animIcons);
            }

            imgLines.setBackground(getAssetPng(this,"line_2"));
            ShowWin();
            Handler Line2= new Handler();
            Line2.postDelayed(this::LoadLine3,1000);
        }
        else
            LoadLine3();
    }

    public void LoadLine3()
    {
        ClearAnim();
        if(intIcon1x3 != 8 &&  intIcon1x3 == intIcon2x3 && LINE >= 3)
        {
            if(intIcon1x3 == intIcon3x3)
            {
                if(intIcon1x3 == intIcon4x3)
                {
                    if(intIcon1x3 == intIcon5x3) intCountIcon=5;
                    else
                        intCountIcon=4;
                }
                else
                    intCountIcon=3;
            }
            else if(intIcon1x2 == 1) intCountIcon=2;
        }
        if(intCountIcon >= 2)
        {
            intNumberIcon = intIcon1x1;
            imgAnim1x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
            imgAnim1x3.setImageResource(R.drawable.b_line_3);
            imgAnim1x3.startAnimation(animIcons);
            imgAnim2x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
            imgAnim2x3.setImageResource(R.drawable.b_line_3);
            imgAnim2x3.startAnimation(animIcons);
            if(intCountIcon>=3)
            {
                imgAnim3x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim3x3.setImageResource(R.drawable.b_line_3);
                imgAnim3x3.startAnimation(animIcons);
            }
            if(intCountIcon>=4)
            {
                imgAnim4x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim4x3.setImageResource(R.drawable.b_line_3);
                imgAnim4x3.startAnimation(animIcons);
            }
            if(intCountIcon>=5)
            {
                imgAnim5x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim5x3.setImageResource(R.drawable.b_line_3);
                imgAnim5x3.startAnimation(animIcons);
            }

            imgLines.setBackground(getAssetPng(this,"line_3"));
            ShowWin();
            Handler Line3= new Handler();
            Line3.postDelayed(this::LoadLine4,1000);
        }
        else
            LoadLine4();
    }

    public void LoadLine4()
    {
        ClearAnim();
        if(intIcon1x1 != 8 && intIcon1x1 == intIcon2x2 && LINE >= 4)
        {
            if(intIcon1x1 == intIcon3x3)
            {
                if(intIcon1x1 == intIcon4x2)
                {
                    if(intIcon1x1 == intIcon5x1) intCountIcon=5;
                    else
                        intCountIcon=4;
                }
                else
                    intCountIcon=3;
            }
            else if(intIcon1x2 == 1) intCountIcon=2;
        }
        if(intCountIcon >= 2)
        {
            intNumberIcon = intIcon1x1;
            imgAnim1x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
            imgAnim1x1.setImageResource(R.drawable.b_line_4);
            imgAnim1x1.startAnimation(animIcons);
            imgAnim2x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
            imgAnim2x2.setImageResource(R.drawable.b_line_4);
            imgAnim2x2.startAnimation(animIcons);
            if(intCountIcon>=3)
            {
                imgAnim3x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim3x3.setImageResource(R.drawable.b_line_4);
                imgAnim3x3.startAnimation(animIcons);
            }
            if(intCountIcon>=4)
            {
                imgAnim4x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim4x2.setImageResource(R.drawable.b_line_4);
                imgAnim4x2.startAnimation(animIcons);
            }
            if(intCountIcon>=5)
            {
                imgAnim5x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x1));
                imgAnim5x1.setImageResource(R.drawable.b_line_4);
                imgAnim5x1.startAnimation(animIcons);
            }

            imgLines.setBackground(getAssetPng(this,"line_4"));
            ShowWin();
            Handler Line4= new Handler();
            Line4.postDelayed(this::LoadLine5,1000);
        }
        else
            LoadLine5();
    }

    public void LoadLine5()
    {
        ClearAnim();
        if(intIcon1x3 != 8 && intIcon1x3 == intIcon2x2 && LINE == 5)
        {
            if(intIcon1x3 == intIcon3x1)
            {
                if(intIcon1x3 == intIcon4x2)
                {
                    if(intIcon1x3 == intIcon5x3) intCountIcon=5;
                    else
                        intCountIcon=4;
                }
                else
                    intCountIcon=3;
            }
            else if(intIcon1x2 == 1) intCountIcon=2;
        }
        if(intCountIcon >= 2)
        {
            intNumberIcon = intIcon1x3;
            imgAnim1x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
            imgAnim1x3.setImageResource(R.drawable.b_line_5);
            imgAnim1x3.startAnimation(animIcons);
            imgAnim2x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
            imgAnim2x2.setImageResource(R.drawable.b_line_5);
            imgAnim2x2.startAnimation(animIcons);
            if(intCountIcon>=3)
            {
                imgAnim3x1.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim3x1.setImageResource(R.drawable.b_line_5);
                imgAnim3x1.startAnimation(animIcons);
            }
            if(intCountIcon>=4)
            {
                imgAnim4x2.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim4x2.setImageResource(R.drawable.b_line_5);
                imgAnim4x2.startAnimation(animIcons);
            }
            if(intCountIcon>=5)
            {
                imgAnim5x3.setBackground(getAssetJpg(this,"icon_"+intIcon1x3));
                imgAnim5x3.setImageResource(R.drawable.b_line_5);
                imgAnim5x3.startAnimation(animIcons);
            }

            imgLines.setBackground(getAssetPng(this,"line_5"));
            ShowWin();
            Handler Line5= new Handler();
            Line5.postDelayed(this::LoadScatter,1000);
        }
        else
            LoadScatter();
    }

    public void LoadScatter()
    {
        if(intCountScatter>=3)
        {
            if(intCountScatter==3)
                intWinLine = TOTALBET *10;
            else if (intCountScatter==4)
                intWinLine = TOTALBET *50;
            else if (intCountScatter==5)
                intWinLine = TOTALBET *250;

            WIN = WIN + intWinLine;
            String strWin = ""+WIN;
            txtWin.setText(strWin);
            txtWin.startAnimation(animTrxt);

           // imgLines.setBackground(this,"lines_0");

            ShowScatter();

            Handler Scatter= new Handler();
            Scatter.postDelayed(()->
            {
                boolSpinReels=false;
                ClearAnim();
            },1000);
        }
        else
        {
            boolSpinReels=false;
            ClearAnim();

            if(WIN==0 && CREDIT < TOTALBET) CheckCredits();
            ShowButtons();
        }
    }

    public void ShowScatter()
    {
        if(intIcon1x1 == 8)
        {
            imgAnim1x1.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim1x1.setImageResource(R.drawable.b_scatter);
            imgAnim1x1.startAnimation(animIcons);
        }
        if(intIcon1x2 == 8)
        {
            imgAnim1x2.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim1x2.setImageResource(R.drawable.b_scatter);
            imgAnim1x2.startAnimation(animIcons);
        }
        if(intIcon1x3 == 8)
        {
            imgAnim1x3.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim1x3.setImageResource(R.drawable.b_scatter);
            imgAnim1x3.startAnimation(animIcons);
        }
        if(intIcon2x1 == 8)
        {
            imgAnim2x1.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim2x1.setImageResource(R.drawable.b_scatter);
            imgAnim2x1.startAnimation(animIcons);
        }
        if(intIcon2x2 == 8)
        {
            imgAnim2x2.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim2x2.setImageResource(R.drawable.b_scatter);
            imgAnim2x2.startAnimation(animIcons);
        }
        if(intIcon2x3 == 8)
        {
            imgAnim2x3.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim2x3.setImageResource(R.drawable.b_scatter);
            imgAnim2x3.startAnimation(animIcons);
        }
        if(intIcon3x1 == 8)
        {
            imgAnim3x1.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim3x1.setImageResource(R.drawable.b_scatter);
            imgAnim3x1.startAnimation(animIcons);
        }
        if(intIcon3x2== 8)
        {
            imgAnim3x2.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim3x2.setImageResource(R.drawable.b_scatter);
            imgAnim3x2.startAnimation(animIcons);
        }
        if(intIcon3x3 == 8)
        {
            imgAnim3x3.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim3x3.setImageResource(R.drawable.b_scatter);
            imgAnim3x3.startAnimation(animIcons);
        }
        if(intIcon4x1 == 8)
        {
            imgAnim4x1.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim4x1.setImageResource(R.drawable.b_scatter);
            imgAnim4x1.startAnimation(animIcons);
        }
        if(intIcon4x2== 8)
        {
            imgAnim4x2.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim4x2.setImageResource(R.drawable.b_scatter);
            imgAnim4x2.startAnimation(animIcons);
        }
        if(intIcon4x3 == 8)
        {
            imgAnim4x3.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim4x3.setImageResource(R.drawable.b_scatter);
            imgAnim4x3.startAnimation(animIcons);
        }
        if(intIcon5x1 == 8)
        {
            imgAnim5x1.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim5x1.setImageResource(R.drawable.b_scatter);
            imgAnim5x1.startAnimation(animIcons);
        }
        if(intIcon5x2== 8)
        {
            imgAnim5x2.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim5x2.setImageResource(R.drawable.b_scatter);
            imgAnim5x2.startAnimation(animIcons);
        }
        if(intIcon5x3 == 8)
        {
            imgAnim5x3.setBackground(getAssetJpg(this,"icone_8"));
            imgAnim5x3.setImageResource(R.drawable.b_scatter);
            imgAnim5x3.startAnimation(animIcons);
        }

    }

    public void ClearAnim()
    {
        intCountIcon = 0;
        intNumberIcon = 0;

        if(imgLines !=null) imgLines.setBackground(null);

        if(imgAnim1x1 !=null)
        {
            imgAnim1x1.setBackground(null);
            imgAnim1x1.setImageResource(0);
            imgAnim1x1.setAnimation(null);
        }
        if(imgAnim1x2 !=null)
        {
            imgAnim1x2.setBackground(null);
            imgAnim1x2.setImageResource(0);
            imgAnim1x2.setAnimation(null);
        }
        if(imgAnim1x3 !=null)
        {
            imgAnim1x3.setBackground(null);
            imgAnim1x3.setImageResource(0);
            imgAnim1x3.setAnimation(null);
        }
        if(imgAnim2x1 !=null)
        {
            imgAnim2x1.setBackground(null);
            imgAnim2x1.setImageResource(0);
            imgAnim2x1.setAnimation(null);
        }
        if(imgAnim2x2 !=null)
        {
            imgAnim2x2.setBackground(null);
            imgAnim2x2.setImageResource(0);
            imgAnim2x2.setAnimation(null);
        }
        if(imgAnim2x3 !=null)
        {
            imgAnim2x3.setBackground(null);
            imgAnim2x3.setImageResource(0);
            imgAnim2x3.setAnimation(null);
        }
        if(imgAnim3x1 !=null)
        {
            imgAnim3x1.setBackground(null);
            imgAnim3x1.setImageResource(0);
            imgAnim3x1.setAnimation(null);
        }
        if(imgAnim3x2 !=null)
        {
            imgAnim3x2.setBackground(null);
            imgAnim3x2.setImageResource(0);
            imgAnim3x2.setAnimation(null);
        }
        if(imgAnim3x3 !=null)
        {
            imgAnim3x3.setBackground(null);
            imgAnim3x3.setImageResource(0);
            imgAnim3x3.setAnimation(null);
        }
        if(imgAnim4x1 !=null)
        {
            imgAnim4x1.setBackground(null);
            imgAnim4x1.setImageResource(0);
            imgAnim4x1.setAnimation(null);
        }
        if(imgAnim4x2 !=null)
        {
            imgAnim4x2.setBackground(null);
            imgAnim4x2.setImageResource(0);
            imgAnim4x2.setAnimation(null);
        }
        if(imgAnim4x3 !=null)
        {
            imgAnim4x3.setBackground(null);
            imgAnim4x3.setImageResource(0);
            imgAnim4x3.setAnimation(null);
        }
        if(imgAnim5x1 !=null)
        {
            imgAnim5x1.setBackground(null);
            imgAnim5x1.setImageResource(0);
            imgAnim5x1.setAnimation(null);
        }
        if(imgAnim5x2 !=null)
        {
            imgAnim5x2.setBackground(null);
            imgAnim5x2.setImageResource(0);
            imgAnim5x2.setAnimation(null);
        }
        if(imgAnim5x3 !=null)
        {
            imgAnim5x3.setBackground(null);
            imgAnim5x3.setImageResource(0);
            imgAnim5x3.setAnimation(null);
        }
    }

    public Drawable getAssetJpg(Context context, String filename)
    {
        AssetManager asset = context.getResources().getAssets();
        InputStream buffer=null;
        try
        {
            buffer = new BufferedInputStream((asset.open("jpg/i"+filename+".jpg")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return new BitmapDrawable(context.getResources(),bitmap);
    }
    public Drawable getAssetPng(Context context, String filename)
    {
        AssetManager asset = context.getResources().getAssets();
        InputStream buffer=null;
        try
        {
            buffer = new BufferedInputStream((asset.open("png/i"+filename+".png")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return new BitmapDrawable(context.getResources(),bitmap);
    }
}
