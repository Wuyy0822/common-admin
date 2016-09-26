package com.panlingxiao.common_admin.service.impl.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.domain.Role;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.mapper.user.UserMapper;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import com.panlingxiao.common_admin.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";

    @Value("${password.hashIterations}")
    private int hashIterations = 2;


    @Override
    public PageInfo<User> findUser(UserRequest userRequest) {
        /*
         * 由于前端传递的参数查询的偏移量和每页的大小
         * 这里需要重新计算这是第几页,通过Mybatis分页插件简化处理
         * 并且默认为第一页开始查询
         */
        PageHelper.startPage((userRequest.getStartIndex() / userRequest.getPageSize()) + 1, userRequest.getPageSize());
        Page<User> users = userMapper.findUser(userRequest);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }


    @Override
    public void addUser(User user) {
        user.setSalt(PasswordUtil.generateHalt());
        user.setPassword(PasswordUtil.encryptCredentail(user.getPassword(), user.getUsername() + user.getSalt(), algorithmName, hashIterations));
        userMapper.addUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User login(UserRequest userRequest) {
        return userMapper.getUserByUserName(userRequest);
    }

    @Override
    public User getUserAuthorizationInfo(UserRequest userRequest) {
        User user = userMapper.getUserAuthorizationInfoById(userRequest.getId());
        Map<Integer,Resource> resourceMap = new HashMap();
        if(user != null) {
           Set<Role> roles = user.getRoles();
            for(Role role : roles){
                List<Resource> resources = role.getResources();
                for(Resource resource : resources){
                    if(resource.getType() == Resource.ResourceType.menu){
                        Integer parentId = resource.getParentId();
                        //判断一级菜单是否存在
                        if(parentId == null || parentId <=0){
                            Integer id = resource.getId();
                            if(!resourceMap.containsKey(id)){
                                resourceMap.put(id,resource);
                            }
                        }else if(resourceMap.containsKey(parentId)){
                            Resource parent = resourceMap.get(parentId);
                            parent.addChildren(resource);
                        }else{

                        }
                    }
                }
            }
        }
        return user;
    }


}
