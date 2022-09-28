package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the SuperFurBoy type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "SuperFurBoys", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class SuperFurBoy implements Model {
  public static final QueryField ID = field("SuperFurBoy", "id");
  public static final QueryField NAME = field("SuperFurBoy", "name");
  public static final QueryField TYPE = field("SuperFurBoy", "type");
  public static final QueryField HEIGHT = field("SuperFurBoy", "height");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="PokemanTypeEnum") PokemanTypeEnum type;
  private final @ModelField(targetType="Int") Integer height;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public PokemanTypeEnum getType() {
      return type;
  }
  
  public Integer getHeight() {
      return height;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private SuperFurBoy(String id, String name, PokemanTypeEnum type, Integer height) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.height = height;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SuperFurBoy superFurBoy = (SuperFurBoy) obj;
      return ObjectsCompat.equals(getId(), superFurBoy.getId()) &&
              ObjectsCompat.equals(getName(), superFurBoy.getName()) &&
              ObjectsCompat.equals(getType(), superFurBoy.getType()) &&
              ObjectsCompat.equals(getHeight(), superFurBoy.getHeight()) &&
              ObjectsCompat.equals(getCreatedAt(), superFurBoy.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), superFurBoy.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getType())
      .append(getHeight())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("SuperFurBoy {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("height=" + String.valueOf(getHeight()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static SuperFurBoy justId(String id) {
    return new SuperFurBoy(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      type,
      height);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    SuperFurBoy build();
    BuildStep id(String id);
    BuildStep type(PokemanTypeEnum type);
    BuildStep height(Integer height);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private PokemanTypeEnum type;
    private Integer height;
    @Override
     public SuperFurBoy build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new SuperFurBoy(
          id,
          name,
          type,
          height);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep type(PokemanTypeEnum type) {
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep height(Integer height) {
        this.height = height;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, PokemanTypeEnum type, Integer height) {
      super.id(id);
      super.name(name)
        .type(type)
        .height(height);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder type(PokemanTypeEnum type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder height(Integer height) {
      return (CopyOfBuilder) super.height(height);
    }
  }
  
}
