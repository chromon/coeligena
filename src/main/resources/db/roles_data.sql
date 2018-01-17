
INSERT INTO `roles` (`id`, `rolename`, `role_content`, `pid`, `status`, `create_time`, `update_time`, `remark`) VALUES
(0, 'Administrators', '超级管理员', 0, 1, null, null, ''),
(0, 'ContentReviewAdministrators', '内容审核管理员', 1,  1, null, null, ''),
(0, 'UnauthenticatedUser', '未验证用户', 0, 1, null, null, ''),
(0, 'RegularUser', '普通用户', 0, 1, null, null, ''),
(0, 'BannedUser', '封禁用户', 0, 1, null, null, ''),
(0, 'CorporateUser', '企业会员', 0, 1, null, null, '');