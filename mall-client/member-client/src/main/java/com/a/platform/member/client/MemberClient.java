package com.a.platform.member.client;

import com.a.platform.common.result.Page;
import com.a.platform.member.model.BackendMemberVO;
import com.a.platform.member.model.MemberPointVO;
import com.a.platform.member.model.MemberQueryParam;
import com.a.platform.member.model.MemberVO;
import com.a.platform.member.model.bo.BackendMemberBO;
import com.a.platform.member.model.bo.MemberBO;
import com.a.platform.member.model.dto.MemberDTO;
import com.a.platform.member.model.dto.MemberFaceBO;

import java.util.List;

/**
 * 会员业务层
 *
 * @author weixing.yang
 * @version 1.0
 * @date 2019/10/22 15:54
 */
public interface MemberClient {

    /**
     * 查询会员列表
     *
     * @param memberQueryParam 查询条件
     * @return
     */
    Page list(MemberQueryParam memberQueryParam);

    /**
     * 修改会员登录次数
     *
     * @param memberId
     * @param now
     */
    void updateLoginNum(Integer memberId, Long now);

    /**
     * 修改会员
     *
     * @param member 会员
     * @param id     会员主键
     * @return Member 会员
     */
    MemberBO edit(MemberDTO member, Integer id);

    /**
     * 删除会员
     *
     * @param clazz Member类
     * @param id    会员主键
     */
    void delete(Class<MemberDTO> clazz, Integer id);

    /**
     * 获取会员
     *
     * @param id 会员表主键
     * @return Member  会员
     */
    MemberBO getModel(Integer id);

    /**
     * 根据用户名查询会员
     *
     * @param uname 用户名
     * @return 会员信息
     */
    MemberBO getMemberByName(String uname);

    /**
     * 根据用户手机号码查询会员
     *
     * @param mobile 手机号码
     * @return 会员信息
     */
    MemberBO getMemberByMobile(String mobile);

    /**
     * 根据邮箱获取用户
     *
     * @param email
     * @return
     */
    MemberBO getMemberByEmail(String email);

    /**
     * 查询当前会员的积分
     *
     * @return 会员vo
     */
    MemberPointVO getMemberPoint();

    /**
     * 生成用户名
     *
     * @param uname 用户填写的用户名
     * @return 用户名数组
     */
    String[] generateMemberUname(String uname);

    /**
     * 会员注册
     *
     * @param member 会员
     * @return 会员信息
     */
    MemberBO register(MemberDTO member);

    /**
     * 会员用户名密码登录
     *
     * @param username       用户名
     * @param password       密码
     * @param memberOrSeller 会员还是卖家，1 会员  2 卖家
     * @return 是否登录成功
     */
    MemberFaceBO login(String username, String password, Integer memberOrSeller);

    /**
     * 动态登录
     *
     * @param phone 手机号码
     * @return 是否登录成功
     */
    MemberFaceBO mobileLogin(String phone, Integer memberOrSeller);

    /**
     * 会员退出
     *
     * @param uid 会员id
     */
    void logout(Integer uid);

    /**
     * 登录会员后的处理
     *
     * @param member
     * @param memberOrSeller 会员还是卖家，1 会员  2 卖家
     * @return
     */
    MemberFaceBO loginHandle(MemberDTO member, Integer memberOrSeller);

    /**
     * 联合登录后处理
     *
     * @param member 会员信息
     * @param uuid   uuid
     * @return 会员信息
     */
    MemberFaceBO connectLoginHandle(MemberDTO member, String uuid);


    /**
     * 验证会员账号密码的正确性(只验证不登录)
     *
     * @param username 用户名/手机号/邮箱
     * @param password 密码
     * @return 正确 true 错误 false
     */
    MemberBO validation(String username, String password);

    /**
     * 根据账号获取当前会员的一些信息，供找回密码使用
     *
     * @param account 用户名/手机号/邮箱
     * @return 会员信息
     */
    MemberBO getMemberByAccount(String account);

    /**
     * 查询新的会员
     *
     * @param length
     * @return
     */
    List<BackendMemberBO> newMember(Integer length);

    /**
     * 根据会员ids获取会员的集合
     *
     * @param memberIds 会员id数组
     * @return 会员信息
     */
    List<MemberBO> getMemberByIds(Integer[] memberIds);


    /**
     * 登陆次数归零
     */
    void loginNumToZero();


    void memberLoginout(Integer memberId);
}