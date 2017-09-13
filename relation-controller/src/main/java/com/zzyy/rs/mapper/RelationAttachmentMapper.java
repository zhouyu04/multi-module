package com.zzyy.rs.mapper;

import com.zzyy.rs.entities.RelationAttachment;
import com.zzyy.rs.entities.RelationAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationAttachmentMapper {
    long countByExample(RelationAttachmentExample example);

    int deleteByExample(RelationAttachmentExample example);

    int deleteByPrimaryKey(Long fileid);

    int insert(RelationAttachment record);

    int insertSelective(RelationAttachment record);

    List<RelationAttachment> selectByExample(RelationAttachmentExample example);

    RelationAttachment selectByPrimaryKey(Long fileid);

    int updateByExampleSelective(@Param("record") RelationAttachment record, @Param("example") RelationAttachmentExample example);

    int updateByExample(@Param("record") RelationAttachment record, @Param("example") RelationAttachmentExample example);

    int updateByPrimaryKeySelective(RelationAttachment record);

    int updateByPrimaryKey(RelationAttachment record);

    int batchInsert(List<RelationAttachment> list);
}