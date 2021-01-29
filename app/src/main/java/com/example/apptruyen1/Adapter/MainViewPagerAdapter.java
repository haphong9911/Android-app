package com.example.apptruyen1.Adapter;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.apptruyen1.Fragment.Fragment_Kham_pha;
import com.example.apptruyen1.Fragment.Fragment_Lich_su;
import com.example.apptruyen1.Fragment.Fragment_Menu;
import com.example.apptruyen1.Fragment.Fragment_The_loai;
import com.example.apptruyen1.Fragment.Fragment_Tim_kiem;

import java.util.ArrayList;

//Chỗ ni Fragment thôi chớ m check thử. Ý là uk
//phần custom tab có hình ni t chưa thử , chưa biết xử lý đoạn này sao.. giờ nếu chỉ có tên thôi thì đc, chứ hình chưa rõ, check tên thử đi
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    Fragment_Tim_kiem tim_kiem;
    Fragment_Lich_su lich_su;
    Fragment_Kham_pha kham_pha;
    Fragment_The_loai the_loai;
    Fragment_Menu menu;


    //Chỗ string bây custom lại cho có hình vs chữ bằng cách dùng arraylist (ko rõ  vì chưa thử)
    String[] tabName = {"Tìm kiếm", "Lịch sử", "Khám phá", "Thể loại", "Menu"};

    public MainViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        kham_pha = new Fragment_Kham_pha();
        tim_kiem = new Fragment_Tim_kiem();
        menu = new Fragment_Menu();
        the_loai = new Fragment_The_loai();
        lich_su = new Fragment_Lich_su();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return tim_kiem;
            case 1:
                return lich_su;
            case 2:
                return kham_pha;
            case 3:
                return the_loai;
            case 4:
                return menu;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabName.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }
}
