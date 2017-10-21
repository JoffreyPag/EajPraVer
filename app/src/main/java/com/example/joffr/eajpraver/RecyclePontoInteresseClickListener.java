package com.example.joffr.eajpraver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by joffr on 21/10/2017.
 */

public class RecyclePontoInteresseClickListener implements RecyclerView.OnItemTouchListener{

    GestureDetector myGestureDetector;
    OnItemClickListener myListener;

    //interface para os metodos que quer-se disponibilizar ao recycle view
    //ela e chamada no construtor dessa classe

    public interface OnItemClickListener{
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    /*
    ordem de chamada: 1- onItercept... , 2- onTouch... , 3- onClick da view
     */
    //intercepta um evento de toque na tela
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        myGestureDetector.onTouchEvent(e);
        return false;
    }

    //chamado quando um toque na view é detectado
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    //chamado quando uma view filha nao quer os eventos sejam interceptados
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public RecyclePontoInteresseClickListener(Context context, final RecyclerView view, OnItemClickListener listener){
       myListener = listener;
        myGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                super.onSingleTapUp(e);

                View childView = view.findChildViewUnder(e.getX(), e.getY());

                if (childView != null && myListener != null) {
                    myListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                View childView = view.findChildViewUnder(e.getX(),e.getY());
                if (childView != null && myListener != null) {
                    myListener.onItemLongClick(childView, view.getChildAdapterPosition(childView));
                }
            }
        });
    }

}
