package org.example;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * Created by  lxr.
 * User: luxurong
 * Date: 2020/7/8
 */
public class t1 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */

    @Test
    public void test(){
        int[] nums = new int[]{1};
        int[] result=searchRange(nums, 1);
        System.out.println(result);
    }



    public int[] searchRange(int[] nums, int target) {
        int begin = 0;
        int end =nums.length-1;
        int index=-1;
        while (begin<=end){
            int middle = (begin+end)>>1;
            if(nums[middle] == target){
                index=middle;
                break;
            }
            else{
                if(nums[middle]<target){
                    begin=middle+1;
                }
                else{
                    end =middle-1;
                }
            }
        }
        int min=index;
        int max=index;
        if(index>=0){
            for(int i=index;i>0&&nums[--i]==target;){
                min=i;
            }
            for(int i=index;i<nums.length-1&&nums[++i]==target;){
                max=i;
            }
        }
        return  new int[]{min,max};
    }




}
