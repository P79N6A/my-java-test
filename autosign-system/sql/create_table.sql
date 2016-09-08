CREATE TABLE `sign_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sign_url` varchar(200) DEFAULT NULL,
  `cookie` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sign_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `info_id` bigint(20) DEFAULT NULL,
  `original_result` text,
  `operation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;