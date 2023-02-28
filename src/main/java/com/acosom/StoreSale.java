/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acosom;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class StoreSale extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5286223965978580269L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"StoreSale\",\"namespace\":\"com.acosom\",\"fields\":[{\"name\":\"store_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"ID of the store where the sale was made.\"},{\"name\":\"sale_amount\",\"type\":\"int\",\"doc\":\"Amount of the sale in local currency. This value is an integer.\"},{\"name\":\"sale_ts\",\"type\":\"long\",\"doc\":\"Epoch timestamp when the sale happened.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<StoreSale> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StoreSale> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<StoreSale> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<StoreSale> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<StoreSale> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this StoreSale to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a StoreSale from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a StoreSale instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static StoreSale fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** ID of the store where the sale was made. */
  private java.lang.String store_id;
  /** Amount of the sale in local currency. This value is an integer. */
  private int sale_amount;
  /** Epoch timestamp when the sale happened. */
  private long sale_ts;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public StoreSale() {}

  /**
   * All-args constructor.
   * @param store_id ID of the store where the sale was made.
   * @param sale_amount Amount of the sale in local currency. This value is an integer.
   * @param sale_ts Epoch timestamp when the sale happened.
   */
  public StoreSale(java.lang.String store_id, java.lang.Integer sale_amount, java.lang.Long sale_ts) {
    this.store_id = store_id;
    this.sale_amount = sale_amount;
    this.sale_ts = sale_ts;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return store_id;
    case 1: return sale_amount;
    case 2: return sale_ts;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: store_id = value$ != null ? value$.toString() : null; break;
    case 1: sale_amount = (java.lang.Integer)value$; break;
    case 2: sale_ts = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'store_id' field.
   * @return ID of the store where the sale was made.
   */
  public java.lang.String getStoreId() {
    return store_id;
  }


  /**
   * Sets the value of the 'store_id' field.
   * ID of the store where the sale was made.
   * @param value the value to set.
   */
  public void setStoreId(java.lang.String value) {
    this.store_id = value;
  }

  /**
   * Gets the value of the 'sale_amount' field.
   * @return Amount of the sale in local currency. This value is an integer.
   */
  public int getSaleAmount() {
    return sale_amount;
  }


  /**
   * Sets the value of the 'sale_amount' field.
   * Amount of the sale in local currency. This value is an integer.
   * @param value the value to set.
   */
  public void setSaleAmount(int value) {
    this.sale_amount = value;
  }

  /**
   * Gets the value of the 'sale_ts' field.
   * @return Epoch timestamp when the sale happened.
   */
  public long getSaleTs() {
    return sale_ts;
  }


  /**
   * Sets the value of the 'sale_ts' field.
   * Epoch timestamp when the sale happened.
   * @param value the value to set.
   */
  public void setSaleTs(long value) {
    this.sale_ts = value;
  }

  /**
   * Creates a new StoreSale RecordBuilder.
   * @return A new StoreSale RecordBuilder
   */
  public static com.acosom.StoreSale.Builder newBuilder() {
    return new com.acosom.StoreSale.Builder();
  }

  /**
   * Creates a new StoreSale RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new StoreSale RecordBuilder
   */
  public static com.acosom.StoreSale.Builder newBuilder(com.acosom.StoreSale.Builder other) {
    if (other == null) {
      return new com.acosom.StoreSale.Builder();
    } else {
      return new com.acosom.StoreSale.Builder(other);
    }
  }

  /**
   * Creates a new StoreSale RecordBuilder by copying an existing StoreSale instance.
   * @param other The existing instance to copy.
   * @return A new StoreSale RecordBuilder
   */
  public static com.acosom.StoreSale.Builder newBuilder(com.acosom.StoreSale other) {
    if (other == null) {
      return new com.acosom.StoreSale.Builder();
    } else {
      return new com.acosom.StoreSale.Builder(other);
    }
  }

  /**
   * RecordBuilder for StoreSale instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<StoreSale>
    implements org.apache.avro.data.RecordBuilder<StoreSale> {

    /** ID of the store where the sale was made. */
    private java.lang.String store_id;
    /** Amount of the sale in local currency. This value is an integer. */
    private int sale_amount;
    /** Epoch timestamp when the sale happened. */
    private long sale_ts;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.acosom.StoreSale.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.store_id)) {
        this.store_id = data().deepCopy(fields()[0].schema(), other.store_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sale_amount)) {
        this.sale_amount = data().deepCopy(fields()[1].schema(), other.sale_amount);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.sale_ts)) {
        this.sale_ts = data().deepCopy(fields()[2].schema(), other.sale_ts);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing StoreSale instance
     * @param other The existing instance to copy.
     */
    private Builder(com.acosom.StoreSale other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.store_id)) {
        this.store_id = data().deepCopy(fields()[0].schema(), other.store_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sale_amount)) {
        this.sale_amount = data().deepCopy(fields()[1].schema(), other.sale_amount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sale_ts)) {
        this.sale_ts = data().deepCopy(fields()[2].schema(), other.sale_ts);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'store_id' field.
      * ID of the store where the sale was made.
      * @return The value.
      */
    public java.lang.String getStoreId() {
      return store_id;
    }


    /**
      * Sets the value of the 'store_id' field.
      * ID of the store where the sale was made.
      * @param value The value of 'store_id'.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder setStoreId(java.lang.String value) {
      validate(fields()[0], value);
      this.store_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'store_id' field has been set.
      * ID of the store where the sale was made.
      * @return True if the 'store_id' field has been set, false otherwise.
      */
    public boolean hasStoreId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'store_id' field.
      * ID of the store where the sale was made.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder clearStoreId() {
      store_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sale_amount' field.
      * Amount of the sale in local currency. This value is an integer.
      * @return The value.
      */
    public int getSaleAmount() {
      return sale_amount;
    }


    /**
      * Sets the value of the 'sale_amount' field.
      * Amount of the sale in local currency. This value is an integer.
      * @param value The value of 'sale_amount'.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder setSaleAmount(int value) {
      validate(fields()[1], value);
      this.sale_amount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sale_amount' field has been set.
      * Amount of the sale in local currency. This value is an integer.
      * @return True if the 'sale_amount' field has been set, false otherwise.
      */
    public boolean hasSaleAmount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sale_amount' field.
      * Amount of the sale in local currency. This value is an integer.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder clearSaleAmount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'sale_ts' field.
      * Epoch timestamp when the sale happened.
      * @return The value.
      */
    public long getSaleTs() {
      return sale_ts;
    }


    /**
      * Sets the value of the 'sale_ts' field.
      * Epoch timestamp when the sale happened.
      * @param value The value of 'sale_ts'.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder setSaleTs(long value) {
      validate(fields()[2], value);
      this.sale_ts = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'sale_ts' field has been set.
      * Epoch timestamp when the sale happened.
      * @return True if the 'sale_ts' field has been set, false otherwise.
      */
    public boolean hasSaleTs() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'sale_ts' field.
      * Epoch timestamp when the sale happened.
      * @return This builder.
      */
    public com.acosom.StoreSale.Builder clearSaleTs() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StoreSale build() {
      try {
        StoreSale record = new StoreSale();
        record.store_id = fieldSetFlags()[0] ? this.store_id : (java.lang.String) defaultValue(fields()[0]);
        record.sale_amount = fieldSetFlags()[1] ? this.sale_amount : (java.lang.Integer) defaultValue(fields()[1]);
        record.sale_ts = fieldSetFlags()[2] ? this.sale_ts : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StoreSale>
    WRITER$ = (org.apache.avro.io.DatumWriter<StoreSale>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StoreSale>
    READER$ = (org.apache.avro.io.DatumReader<StoreSale>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.store_id);

    out.writeInt(this.sale_amount);

    out.writeLong(this.sale_ts);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.store_id = in.readString();

      this.sale_amount = in.readInt();

      this.sale_ts = in.readLong();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.store_id = in.readString();
          break;

        case 1:
          this.sale_amount = in.readInt();
          break;

        case 2:
          this.sale_ts = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










