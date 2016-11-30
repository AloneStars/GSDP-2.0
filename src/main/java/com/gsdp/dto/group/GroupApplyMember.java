package com.gsdp.dto.group;

import com.gsdp.entity.Page;
import com.gsdp.entity.group.Member;

import java.util.List;

/**
 * 这里主要是封装通过分页查找的团队里面的特定状态的人数(包括这个人的详细信息，但是密码给摸去了)
 *--
 * Created by yizijun on 2016/11/29 0029.
 */
public class GroupApplyMember {

    private Page page;

    private List<Member> members;

    public GroupApplyMember() {}

    public GroupApplyMember(Page page, List<Member> members) {
        this.page = page;
        this.members = members;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupApplyMember{" +
                "page=" + page +
                ", members=" + members +
                '}';
    }
}
