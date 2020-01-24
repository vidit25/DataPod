INSERT INTO datapoddb.oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)
 VALUES ('thedatapod-client', 'resource-server-rest-api',
 /*datapod@2020*/'$2a$04$d9JVJqfXp9fgvUDF/6b4s.sLGbzGkNGzuWLQMQDXGLH2VHCOn4piK',
 'superadmin,admin,manager', 'password,authorization_code,refresh_token,implicit', 'USER', 180, 2592000);
 
INSERT INTO datapoddb.authority(id, name) VALUES (1, 'SUPERADMIN');
INSERT INTO datapoddb.authority(id, name) VALUES (2, 'ADMIN');
INSERT INTO datapoddb.authority(id, name) VALUES (3, 'MANAGER');

commit;
