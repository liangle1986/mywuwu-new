package com.mywuwu.gecco.crawler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.gecco.crawler.entity.SysUser;
import com.mywuwu.gecco.crawler.mapper.SysUserMapper;
import com.mywuwu.gecco.crawler.service.ISysUserService;
import org.springframework.stereotype.Service;


/**
 * 用户表 服务实现类
 * @author wisdom
 * @since 2019-04-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    /**
//     * 用户列表
//     * @param map
//     * @return
//     */
//    @Override
//    public PageResult userList(Map map) {
//        int page = Integer.parseInt(map.get("page").toString());
//        int limit = Integer.parseInt(map.get("limit").toString());
//        Page<SysUser> userPage = new Page<>(page, limit);
//        //分页查询
//        List<SysUser> userList = sysUserMapper.selectPageMap(userPage,map);
//        return PageResult.success(userList,userPage.getTotal());
//    }
//
//    /**
//     * 用户保存
//     * @return
//     */
//    @Override
//    public Result saveOrUpdate(SysUser sysUser) {
//        String message = "添加成功";
//        try{
//            if(sysUser.getId()==null){
//                sysUserMapper.insert(sysUser);
//            }else{
//                SysUser oldUser = sysUserMapper.selectById(sysUser.getId());
//                if(!oldUser.getPassword().equals(sysUser.getPassword())){
//                    sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()));
//                }
//                sysUserMapper.updateById(sysUser);
//                message = "修改成功";
//            }
//            return Result.success(message);
//        }catch (RuntimeException e){
//            return Result.error("很抱歉，请稍后重试");
//        }
//    }
//
//    /**
//     * 登录动作
//     * @return
//     */
//    @Override
//    public Result login(SysUser sysUser) {
//        HttpSession session = SessionUtil.getSession();
//        sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()));
//        SysUser user = sysUserMapper.selectOne(sysUser);
//        if(user != null){
//            session.setAttribute("user",user);
//            session.setAttribute("userId",user.getId());
//            return Result.success("登录成功");
//        }
//        return Result.error("账户或密码错误");
//    }
//    /**
//     * 注册动作
//     * @return
//     */
//    @Override
//    public Result register(SysUser sysUser) {
//        EntityWrapper entityWrapper = new EntityWrapper();
//        entityWrapper.eq("username",sysUser.getUsername());
//        Integer count = sysUserMapper.selectCount(entityWrapper);
//        if(count>0){
//            return Result.error("用户名已存在");
//        }
//        sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()));
//        sysUserMapper.insert(sysUser);
//        return Result.success("注册成功");
//    }
}
