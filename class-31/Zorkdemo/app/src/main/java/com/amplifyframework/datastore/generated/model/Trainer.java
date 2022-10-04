package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Trainer type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Trainers", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Trainer implements Model {
  public static final QueryField ID = field("Trainer", "id");
  public static final QueryField NAME = field("Trainer", "name");
  public static final QueryField PRODUCT_IMAGE_S3_KEY = field("Trainer", "productImageS3Key");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String") String productImageS3Key;
  private final @ModelField(targetType="SuperFurBoy") @HasMany(associatedWith = "trainer", type = SuperFurBoy.class) List<SuperFurBoy> superFurBoys = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getProductImageS3Key() {
      return productImageS3Key;
  }
  
  public List<SuperFurBoy> getSuperFurBoys() {
      return superFurBoys;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Trainer(String id, String name, String productImageS3Key) {
    this.id = id;
    this.name = name;
    this.productImageS3Key = productImageS3Key;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Trainer trainer = (Trainer) obj;
      return ObjectsCompat.equals(getId(), trainer.getId()) &&
              ObjectsCompat.equals(getName(), trainer.getName()) &&
              ObjectsCompat.equals(getProductImageS3Key(), trainer.getProductImageS3Key()) &&
              ObjectsCompat.equals(getCreatedAt(), trainer.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), trainer.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getProductImageS3Key())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Trainer {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("productImageS3Key=" + String.valueOf(getProductImageS3Key()) + ", ")
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
  public static Trainer justId(String id) {
    return new Trainer(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      productImageS3Key);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    Trainer build();
    BuildStep id(String id);
    BuildStep productImageS3Key(String productImageS3Key);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private String productImageS3Key;
    @Override
     public Trainer build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Trainer(
          id,
          name,
          productImageS3Key);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep productImageS3Key(String productImageS3Key) {
        this.productImageS3Key = productImageS3Key;
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
    private CopyOfBuilder(String id, String name, String productImageS3Key) {
      super.id(id);
      super.name(name)
        .productImageS3Key(productImageS3Key);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder productImageS3Key(String productImageS3Key) {
      return (CopyOfBuilder) super.productImageS3Key(productImageS3Key);
    }
  }
  
}
