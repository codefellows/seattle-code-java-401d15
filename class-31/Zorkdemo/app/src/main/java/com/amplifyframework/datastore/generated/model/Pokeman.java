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

/** This is an auto generated class representing the Pokeman type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Pokemen", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Pokeman implements Model {
  public static final QueryField ID = field("Pokeman", "id");
  public static final QueryField NAME = field("Pokeman", "name");
  public static final QueryField TYPE = field("Pokeman", "type");
  public static final QueryField HEIGHT = field("Pokeman", "height");
  public static final QueryField DATE_CREATED = field("Pokeman", "dateCreated");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="PokemanTypeEnum") PokemanTypeEnum type;
  private final @ModelField(targetType="Int") Integer height;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime dateCreated;
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
  
  public Temporal.DateTime getDateCreated() {
      return dateCreated;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Pokeman(String id, String name, PokemanTypeEnum type, Integer height, Temporal.DateTime dateCreated) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.height = height;
    this.dateCreated = dateCreated;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Pokeman pokeman = (Pokeman) obj;
      return ObjectsCompat.equals(getId(), pokeman.getId()) &&
              ObjectsCompat.equals(getName(), pokeman.getName()) &&
              ObjectsCompat.equals(getType(), pokeman.getType()) &&
              ObjectsCompat.equals(getHeight(), pokeman.getHeight()) &&
              ObjectsCompat.equals(getDateCreated(), pokeman.getDateCreated()) &&
              ObjectsCompat.equals(getCreatedAt(), pokeman.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), pokeman.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getType())
      .append(getHeight())
      .append(getDateCreated())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Pokeman {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("height=" + String.valueOf(getHeight()) + ", ")
      .append("dateCreated=" + String.valueOf(getDateCreated()) + ", ")
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
  public static Pokeman justId(String id) {
    return new Pokeman(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      type,
      height,
      dateCreated);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    Pokeman build();
    BuildStep id(String id);
    BuildStep type(PokemanTypeEnum type);
    BuildStep height(Integer height);
    BuildStep dateCreated(Temporal.DateTime dateCreated);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private PokemanTypeEnum type;
    private Integer height;
    private Temporal.DateTime dateCreated;
    @Override
     public Pokeman build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Pokeman(
          id,
          name,
          type,
          height,
          dateCreated);
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
    
    @Override
     public BuildStep dateCreated(Temporal.DateTime dateCreated) {
        this.dateCreated = dateCreated;
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
    private CopyOfBuilder(String id, String name, PokemanTypeEnum type, Integer height, Temporal.DateTime dateCreated) {
      super.id(id);
      super.name(name)
        .type(type)
        .height(height)
        .dateCreated(dateCreated);
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
    
    @Override
     public CopyOfBuilder dateCreated(Temporal.DateTime dateCreated) {
      return (CopyOfBuilder) super.dateCreated(dateCreated);
    }
  }
  
}
