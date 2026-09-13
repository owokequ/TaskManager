CREATE TABLE workspace (
    id BIGINT,
    name VARCHAR(100) NOT NULL,
    created_by_user_id BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_workspace PRIMARY KEY (id),
    CONSTRAINT fk_workspace_created_by FOREIGN KEY (created_by_user_id) REFERENCES users (id)
)