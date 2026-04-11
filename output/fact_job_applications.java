// ORM class for table 'fact_job_applications'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Apr 10 21:29:47 MSK 2026
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class fact_job_applications extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("fact_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fact_id = (Long)value;
      }
    });
    setters.put("job_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_number = (Long)value;
      }
    });
    setters.put("doc_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.doc_number = (Integer)value;
      }
    });
    setters.put("borough", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.borough = (String)value;
      }
    });
    setters.put("house_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.house_number = (String)value;
      }
    });
    setters.put("street_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.street_name = (String)value;
      }
    });
    setters.put("block", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.block = (Integer)value;
      }
    });
    setters.put("lot", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.lot = (Integer)value;
      }
    });
    setters.put("bin_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.bin_number = (Long)value;
      }
    });
    setters.put("job_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_type = (String)value;
      }
    });
    setters.put("job_status", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_status = (String)value;
      }
    });
    setters.put("job_status_descr", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_status_descr = (String)value;
      }
    });
    setters.put("latest_action_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.latest_action_date = (String)value;
      }
    });
    setters.put("building_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.building_type = (String)value;
      }
    });
    setters.put("community_board", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.community_board = (String)value;
      }
    });
    setters.put("cluster", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.cluster = (String)value;
      }
    });
    setters.put("landmarked", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.landmarked = (String)value;
      }
    });
    setters.put("adult_estab", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.adult_estab = (String)value;
      }
    });
    setters.put("loft_board", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.loft_board = (String)value;
      }
    });
    setters.put("city_owned", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.city_owned = (String)value;
      }
    });
    setters.put("little_e", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.little_e = (String)value;
      }
    });
    setters.put("pc_filed", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.pc_filed = (String)value;
      }
    });
    setters.put("efiling_filed", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.efiling_filed = (String)value;
      }
    });
    setters.put("plumbing", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.plumbing = (String)value;
      }
    });
    setters.put("mechanical", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.mechanical = (String)value;
      }
    });
    setters.put("boiler", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.boiler = (String)value;
      }
    });
    setters.put("fuel_burning", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fuel_burning = (String)value;
      }
    });
    setters.put("fuel_storage", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fuel_storage = (String)value;
      }
    });
    setters.put("standpipe", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.standpipe = (String)value;
      }
    });
    setters.put("sprinkler", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.sprinkler = (String)value;
      }
    });
    setters.put("fire_alarm", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fire_alarm = (String)value;
      }
    });
    setters.put("equipment", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.equipment = (String)value;
      }
    });
    setters.put("fire_suppression", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fire_suppression = (String)value;
      }
    });
    setters.put("curb_cut", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.curb_cut = (String)value;
      }
    });
    setters.put("other", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.other = (String)value;
      }
    });
    setters.put("other_description", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.other_description = (String)value;
      }
    });
    setters.put("applicant_first_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.applicant_first_name = (String)value;
      }
    });
    setters.put("applicant_last_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.applicant_last_name = (String)value;
      }
    });
    setters.put("applicant_professional_title", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.applicant_professional_title = (String)value;
      }
    });
    setters.put("applicant_license", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.applicant_license = (String)value;
      }
    });
    setters.put("professional_cert", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.professional_cert = (String)value;
      }
    });
    setters.put("pre_filing_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.pre_filing_date = (String)value;
      }
    });
    setters.put("paid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.paid = (String)value;
      }
    });
    setters.put("fully_paid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fully_paid = (String)value;
      }
    });
    setters.put("assigned", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.assigned = (String)value;
      }
    });
    setters.put("approved", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.approved = (String)value;
      }
    });
    setters.put("fully_permitted", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fully_permitted = (String)value;
      }
    });
    setters.put("initial_cost", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.initial_cost = (java.math.BigDecimal)value;
      }
    });
    setters.put("total_est_fee", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.total_est_fee = (java.math.BigDecimal)value;
      }
    });
    setters.put("fee_status", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.fee_status = (String)value;
      }
    });
    setters.put("existing_zoning_sqft", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.existing_zoning_sqft = (java.math.BigDecimal)value;
      }
    });
    setters.put("proposed_zoning_sqft", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.proposed_zoning_sqft = (java.math.BigDecimal)value;
      }
    });
    setters.put("horizontal_enlrgmt", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.horizontal_enlrgmt = (String)value;
      }
    });
    setters.put("vertical_enlrgmt", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.vertical_enlrgmt = (String)value;
      }
    });
    setters.put("enlargement_sqft", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.enlargement_sqft = (java.math.BigDecimal)value;
      }
    });
    setters.put("street_frontage", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.street_frontage = (java.math.BigDecimal)value;
      }
    });
    setters.put("existing_no_of_stories", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.existing_no_of_stories = (java.math.BigDecimal)value;
      }
    });
    setters.put("proposed_no_of_stories", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.proposed_no_of_stories = (java.math.BigDecimal)value;
      }
    });
    setters.put("existing_height", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.existing_height = (java.math.BigDecimal)value;
      }
    });
    setters.put("proposed_height", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.proposed_height = (java.math.BigDecimal)value;
      }
    });
    setters.put("existing_dwelling_units", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.existing_dwelling_units = (Integer)value;
      }
    });
    setters.put("proposed_dwelling_units", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.proposed_dwelling_units = (Integer)value;
      }
    });
    setters.put("existing_occupancy", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.existing_occupancy = (String)value;
      }
    });
    setters.put("proposed_occupancy", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.proposed_occupancy = (String)value;
      }
    });
    setters.put("site_fill", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.site_fill = (String)value;
      }
    });
    setters.put("zoning_dist1", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.zoning_dist1 = (String)value;
      }
    });
    setters.put("zoning_dist2", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.zoning_dist2 = (String)value;
      }
    });
    setters.put("zoning_dist3", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.zoning_dist3 = (String)value;
      }
    });
    setters.put("special_district1", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.special_district1 = (String)value;
      }
    });
    setters.put("special_district2", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.special_district2 = (String)value;
      }
    });
    setters.put("owner_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_type = (String)value;
      }
    });
    setters.put("non_profit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.non_profit = (String)value;
      }
    });
    setters.put("owner_first_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_first_name = (String)value;
      }
    });
    setters.put("owner_last_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_last_name = (String)value;
      }
    });
    setters.put("owner_business_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_business_name = (String)value;
      }
    });
    setters.put("owner_house_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_house_number = (String)value;
      }
    });
    setters.put("owner_house_street_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_house_street_name = (String)value;
      }
    });
    setters.put("city", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.city = (String)value;
      }
    });
    setters.put("state", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.state = (String)value;
      }
    });
    setters.put("zip", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.zip = (String)value;
      }
    });
    setters.put("owner_phone", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.owner_phone = (String)value;
      }
    });
    setters.put("job_description", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_description = (String)value;
      }
    });
    setters.put("dobrundate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.dobrundate = (String)value;
      }
    });
    setters.put("job_s1_no", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_s1_no = (String)value;
      }
    });
    setters.put("total_construction_floor_area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.total_construction_floor_area = (java.math.BigDecimal)value;
      }
    });
    setters.put("withdrawal_flag", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.withdrawal_flag = (String)value;
      }
    });
    setters.put("signoff_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.signoff_date = (String)value;
      }
    });
    setters.put("special_action_status", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.special_action_status = (String)value;
      }
    });
    setters.put("special_action_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.special_action_date = (String)value;
      }
    });
    setters.put("building_class", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.building_class = (String)value;
      }
    });
    setters.put("job_no_good_count", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.job_no_good_count = (Integer)value;
      }
    });
    setters.put("gis_latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_latitude = (Double)value;
      }
    });
    setters.put("gis_longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_longitude = (Double)value;
      }
    });
    setters.put("gis_council_district", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_council_district = (String)value;
      }
    });
    setters.put("gis_census_tract", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_census_tract = (String)value;
      }
    });
    setters.put("gis_nta_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_nta_name = (String)value;
      }
    });
    setters.put("gis_bin", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.gis_bin = (String)value;
      }
    });
    setters.put("created_at", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        fact_job_applications.this.created_at = (java.sql.Timestamp)value;
      }
    });
  }
  public fact_job_applications() {
    init0();
  }
  private Long fact_id;
  public Long get_fact_id() {
    return fact_id;
  }
  public void set_fact_id(Long fact_id) {
    this.fact_id = fact_id;
  }
  public fact_job_applications with_fact_id(Long fact_id) {
    this.fact_id = fact_id;
    return this;
  }
  private Long job_number;
  public Long get_job_number() {
    return job_number;
  }
  public void set_job_number(Long job_number) {
    this.job_number = job_number;
  }
  public fact_job_applications with_job_number(Long job_number) {
    this.job_number = job_number;
    return this;
  }
  private Integer doc_number;
  public Integer get_doc_number() {
    return doc_number;
  }
  public void set_doc_number(Integer doc_number) {
    this.doc_number = doc_number;
  }
  public fact_job_applications with_doc_number(Integer doc_number) {
    this.doc_number = doc_number;
    return this;
  }
  private String borough;
  public String get_borough() {
    return borough;
  }
  public void set_borough(String borough) {
    this.borough = borough;
  }
  public fact_job_applications with_borough(String borough) {
    this.borough = borough;
    return this;
  }
  private String house_number;
  public String get_house_number() {
    return house_number;
  }
  public void set_house_number(String house_number) {
    this.house_number = house_number;
  }
  public fact_job_applications with_house_number(String house_number) {
    this.house_number = house_number;
    return this;
  }
  private String street_name;
  public String get_street_name() {
    return street_name;
  }
  public void set_street_name(String street_name) {
    this.street_name = street_name;
  }
  public fact_job_applications with_street_name(String street_name) {
    this.street_name = street_name;
    return this;
  }
  private Integer block;
  public Integer get_block() {
    return block;
  }
  public void set_block(Integer block) {
    this.block = block;
  }
  public fact_job_applications with_block(Integer block) {
    this.block = block;
    return this;
  }
  private Integer lot;
  public Integer get_lot() {
    return lot;
  }
  public void set_lot(Integer lot) {
    this.lot = lot;
  }
  public fact_job_applications with_lot(Integer lot) {
    this.lot = lot;
    return this;
  }
  private Long bin_number;
  public Long get_bin_number() {
    return bin_number;
  }
  public void set_bin_number(Long bin_number) {
    this.bin_number = bin_number;
  }
  public fact_job_applications with_bin_number(Long bin_number) {
    this.bin_number = bin_number;
    return this;
  }
  private String job_type;
  public String get_job_type() {
    return job_type;
  }
  public void set_job_type(String job_type) {
    this.job_type = job_type;
  }
  public fact_job_applications with_job_type(String job_type) {
    this.job_type = job_type;
    return this;
  }
  private String job_status;
  public String get_job_status() {
    return job_status;
  }
  public void set_job_status(String job_status) {
    this.job_status = job_status;
  }
  public fact_job_applications with_job_status(String job_status) {
    this.job_status = job_status;
    return this;
  }
  private String job_status_descr;
  public String get_job_status_descr() {
    return job_status_descr;
  }
  public void set_job_status_descr(String job_status_descr) {
    this.job_status_descr = job_status_descr;
  }
  public fact_job_applications with_job_status_descr(String job_status_descr) {
    this.job_status_descr = job_status_descr;
    return this;
  }
  private String latest_action_date;
  public String get_latest_action_date() {
    return latest_action_date;
  }
  public void set_latest_action_date(String latest_action_date) {
    this.latest_action_date = latest_action_date;
  }
  public fact_job_applications with_latest_action_date(String latest_action_date) {
    this.latest_action_date = latest_action_date;
    return this;
  }
  private String building_type;
  public String get_building_type() {
    return building_type;
  }
  public void set_building_type(String building_type) {
    this.building_type = building_type;
  }
  public fact_job_applications with_building_type(String building_type) {
    this.building_type = building_type;
    return this;
  }
  private String community_board;
  public String get_community_board() {
    return community_board;
  }
  public void set_community_board(String community_board) {
    this.community_board = community_board;
  }
  public fact_job_applications with_community_board(String community_board) {
    this.community_board = community_board;
    return this;
  }
  private String cluster;
  public String get_cluster() {
    return cluster;
  }
  public void set_cluster(String cluster) {
    this.cluster = cluster;
  }
  public fact_job_applications with_cluster(String cluster) {
    this.cluster = cluster;
    return this;
  }
  private String landmarked;
  public String get_landmarked() {
    return landmarked;
  }
  public void set_landmarked(String landmarked) {
    this.landmarked = landmarked;
  }
  public fact_job_applications with_landmarked(String landmarked) {
    this.landmarked = landmarked;
    return this;
  }
  private String adult_estab;
  public String get_adult_estab() {
    return adult_estab;
  }
  public void set_adult_estab(String adult_estab) {
    this.adult_estab = adult_estab;
  }
  public fact_job_applications with_adult_estab(String adult_estab) {
    this.adult_estab = adult_estab;
    return this;
  }
  private String loft_board;
  public String get_loft_board() {
    return loft_board;
  }
  public void set_loft_board(String loft_board) {
    this.loft_board = loft_board;
  }
  public fact_job_applications with_loft_board(String loft_board) {
    this.loft_board = loft_board;
    return this;
  }
  private String city_owned;
  public String get_city_owned() {
    return city_owned;
  }
  public void set_city_owned(String city_owned) {
    this.city_owned = city_owned;
  }
  public fact_job_applications with_city_owned(String city_owned) {
    this.city_owned = city_owned;
    return this;
  }
  private String little_e;
  public String get_little_e() {
    return little_e;
  }
  public void set_little_e(String little_e) {
    this.little_e = little_e;
  }
  public fact_job_applications with_little_e(String little_e) {
    this.little_e = little_e;
    return this;
  }
  private String pc_filed;
  public String get_pc_filed() {
    return pc_filed;
  }
  public void set_pc_filed(String pc_filed) {
    this.pc_filed = pc_filed;
  }
  public fact_job_applications with_pc_filed(String pc_filed) {
    this.pc_filed = pc_filed;
    return this;
  }
  private String efiling_filed;
  public String get_efiling_filed() {
    return efiling_filed;
  }
  public void set_efiling_filed(String efiling_filed) {
    this.efiling_filed = efiling_filed;
  }
  public fact_job_applications with_efiling_filed(String efiling_filed) {
    this.efiling_filed = efiling_filed;
    return this;
  }
  private String plumbing;
  public String get_plumbing() {
    return plumbing;
  }
  public void set_plumbing(String plumbing) {
    this.plumbing = plumbing;
  }
  public fact_job_applications with_plumbing(String plumbing) {
    this.plumbing = plumbing;
    return this;
  }
  private String mechanical;
  public String get_mechanical() {
    return mechanical;
  }
  public void set_mechanical(String mechanical) {
    this.mechanical = mechanical;
  }
  public fact_job_applications with_mechanical(String mechanical) {
    this.mechanical = mechanical;
    return this;
  }
  private String boiler;
  public String get_boiler() {
    return boiler;
  }
  public void set_boiler(String boiler) {
    this.boiler = boiler;
  }
  public fact_job_applications with_boiler(String boiler) {
    this.boiler = boiler;
    return this;
  }
  private String fuel_burning;
  public String get_fuel_burning() {
    return fuel_burning;
  }
  public void set_fuel_burning(String fuel_burning) {
    this.fuel_burning = fuel_burning;
  }
  public fact_job_applications with_fuel_burning(String fuel_burning) {
    this.fuel_burning = fuel_burning;
    return this;
  }
  private String fuel_storage;
  public String get_fuel_storage() {
    return fuel_storage;
  }
  public void set_fuel_storage(String fuel_storage) {
    this.fuel_storage = fuel_storage;
  }
  public fact_job_applications with_fuel_storage(String fuel_storage) {
    this.fuel_storage = fuel_storage;
    return this;
  }
  private String standpipe;
  public String get_standpipe() {
    return standpipe;
  }
  public void set_standpipe(String standpipe) {
    this.standpipe = standpipe;
  }
  public fact_job_applications with_standpipe(String standpipe) {
    this.standpipe = standpipe;
    return this;
  }
  private String sprinkler;
  public String get_sprinkler() {
    return sprinkler;
  }
  public void set_sprinkler(String sprinkler) {
    this.sprinkler = sprinkler;
  }
  public fact_job_applications with_sprinkler(String sprinkler) {
    this.sprinkler = sprinkler;
    return this;
  }
  private String fire_alarm;
  public String get_fire_alarm() {
    return fire_alarm;
  }
  public void set_fire_alarm(String fire_alarm) {
    this.fire_alarm = fire_alarm;
  }
  public fact_job_applications with_fire_alarm(String fire_alarm) {
    this.fire_alarm = fire_alarm;
    return this;
  }
  private String equipment;
  public String get_equipment() {
    return equipment;
  }
  public void set_equipment(String equipment) {
    this.equipment = equipment;
  }
  public fact_job_applications with_equipment(String equipment) {
    this.equipment = equipment;
    return this;
  }
  private String fire_suppression;
  public String get_fire_suppression() {
    return fire_suppression;
  }
  public void set_fire_suppression(String fire_suppression) {
    this.fire_suppression = fire_suppression;
  }
  public fact_job_applications with_fire_suppression(String fire_suppression) {
    this.fire_suppression = fire_suppression;
    return this;
  }
  private String curb_cut;
  public String get_curb_cut() {
    return curb_cut;
  }
  public void set_curb_cut(String curb_cut) {
    this.curb_cut = curb_cut;
  }
  public fact_job_applications with_curb_cut(String curb_cut) {
    this.curb_cut = curb_cut;
    return this;
  }
  private String other;
  public String get_other() {
    return other;
  }
  public void set_other(String other) {
    this.other = other;
  }
  public fact_job_applications with_other(String other) {
    this.other = other;
    return this;
  }
  private String other_description;
  public String get_other_description() {
    return other_description;
  }
  public void set_other_description(String other_description) {
    this.other_description = other_description;
  }
  public fact_job_applications with_other_description(String other_description) {
    this.other_description = other_description;
    return this;
  }
  private String applicant_first_name;
  public String get_applicant_first_name() {
    return applicant_first_name;
  }
  public void set_applicant_first_name(String applicant_first_name) {
    this.applicant_first_name = applicant_first_name;
  }
  public fact_job_applications with_applicant_first_name(String applicant_first_name) {
    this.applicant_first_name = applicant_first_name;
    return this;
  }
  private String applicant_last_name;
  public String get_applicant_last_name() {
    return applicant_last_name;
  }
  public void set_applicant_last_name(String applicant_last_name) {
    this.applicant_last_name = applicant_last_name;
  }
  public fact_job_applications with_applicant_last_name(String applicant_last_name) {
    this.applicant_last_name = applicant_last_name;
    return this;
  }
  private String applicant_professional_title;
  public String get_applicant_professional_title() {
    return applicant_professional_title;
  }
  public void set_applicant_professional_title(String applicant_professional_title) {
    this.applicant_professional_title = applicant_professional_title;
  }
  public fact_job_applications with_applicant_professional_title(String applicant_professional_title) {
    this.applicant_professional_title = applicant_professional_title;
    return this;
  }
  private String applicant_license;
  public String get_applicant_license() {
    return applicant_license;
  }
  public void set_applicant_license(String applicant_license) {
    this.applicant_license = applicant_license;
  }
  public fact_job_applications with_applicant_license(String applicant_license) {
    this.applicant_license = applicant_license;
    return this;
  }
  private String professional_cert;
  public String get_professional_cert() {
    return professional_cert;
  }
  public void set_professional_cert(String professional_cert) {
    this.professional_cert = professional_cert;
  }
  public fact_job_applications with_professional_cert(String professional_cert) {
    this.professional_cert = professional_cert;
    return this;
  }
  private String pre_filing_date;
  public String get_pre_filing_date() {
    return pre_filing_date;
  }
  public void set_pre_filing_date(String pre_filing_date) {
    this.pre_filing_date = pre_filing_date;
  }
  public fact_job_applications with_pre_filing_date(String pre_filing_date) {
    this.pre_filing_date = pre_filing_date;
    return this;
  }
  private String paid;
  public String get_paid() {
    return paid;
  }
  public void set_paid(String paid) {
    this.paid = paid;
  }
  public fact_job_applications with_paid(String paid) {
    this.paid = paid;
    return this;
  }
  private String fully_paid;
  public String get_fully_paid() {
    return fully_paid;
  }
  public void set_fully_paid(String fully_paid) {
    this.fully_paid = fully_paid;
  }
  public fact_job_applications with_fully_paid(String fully_paid) {
    this.fully_paid = fully_paid;
    return this;
  }
  private String assigned;
  public String get_assigned() {
    return assigned;
  }
  public void set_assigned(String assigned) {
    this.assigned = assigned;
  }
  public fact_job_applications with_assigned(String assigned) {
    this.assigned = assigned;
    return this;
  }
  private String approved;
  public String get_approved() {
    return approved;
  }
  public void set_approved(String approved) {
    this.approved = approved;
  }
  public fact_job_applications with_approved(String approved) {
    this.approved = approved;
    return this;
  }
  private String fully_permitted;
  public String get_fully_permitted() {
    return fully_permitted;
  }
  public void set_fully_permitted(String fully_permitted) {
    this.fully_permitted = fully_permitted;
  }
  public fact_job_applications with_fully_permitted(String fully_permitted) {
    this.fully_permitted = fully_permitted;
    return this;
  }
  private java.math.BigDecimal initial_cost;
  public java.math.BigDecimal get_initial_cost() {
    return initial_cost;
  }
  public void set_initial_cost(java.math.BigDecimal initial_cost) {
    this.initial_cost = initial_cost;
  }
  public fact_job_applications with_initial_cost(java.math.BigDecimal initial_cost) {
    this.initial_cost = initial_cost;
    return this;
  }
  private java.math.BigDecimal total_est_fee;
  public java.math.BigDecimal get_total_est_fee() {
    return total_est_fee;
  }
  public void set_total_est_fee(java.math.BigDecimal total_est_fee) {
    this.total_est_fee = total_est_fee;
  }
  public fact_job_applications with_total_est_fee(java.math.BigDecimal total_est_fee) {
    this.total_est_fee = total_est_fee;
    return this;
  }
  private String fee_status;
  public String get_fee_status() {
    return fee_status;
  }
  public void set_fee_status(String fee_status) {
    this.fee_status = fee_status;
  }
  public fact_job_applications with_fee_status(String fee_status) {
    this.fee_status = fee_status;
    return this;
  }
  private java.math.BigDecimal existing_zoning_sqft;
  public java.math.BigDecimal get_existing_zoning_sqft() {
    return existing_zoning_sqft;
  }
  public void set_existing_zoning_sqft(java.math.BigDecimal existing_zoning_sqft) {
    this.existing_zoning_sqft = existing_zoning_sqft;
  }
  public fact_job_applications with_existing_zoning_sqft(java.math.BigDecimal existing_zoning_sqft) {
    this.existing_zoning_sqft = existing_zoning_sqft;
    return this;
  }
  private java.math.BigDecimal proposed_zoning_sqft;
  public java.math.BigDecimal get_proposed_zoning_sqft() {
    return proposed_zoning_sqft;
  }
  public void set_proposed_zoning_sqft(java.math.BigDecimal proposed_zoning_sqft) {
    this.proposed_zoning_sqft = proposed_zoning_sqft;
  }
  public fact_job_applications with_proposed_zoning_sqft(java.math.BigDecimal proposed_zoning_sqft) {
    this.proposed_zoning_sqft = proposed_zoning_sqft;
    return this;
  }
  private String horizontal_enlrgmt;
  public String get_horizontal_enlrgmt() {
    return horizontal_enlrgmt;
  }
  public void set_horizontal_enlrgmt(String horizontal_enlrgmt) {
    this.horizontal_enlrgmt = horizontal_enlrgmt;
  }
  public fact_job_applications with_horizontal_enlrgmt(String horizontal_enlrgmt) {
    this.horizontal_enlrgmt = horizontal_enlrgmt;
    return this;
  }
  private String vertical_enlrgmt;
  public String get_vertical_enlrgmt() {
    return vertical_enlrgmt;
  }
  public void set_vertical_enlrgmt(String vertical_enlrgmt) {
    this.vertical_enlrgmt = vertical_enlrgmt;
  }
  public fact_job_applications with_vertical_enlrgmt(String vertical_enlrgmt) {
    this.vertical_enlrgmt = vertical_enlrgmt;
    return this;
  }
  private java.math.BigDecimal enlargement_sqft;
  public java.math.BigDecimal get_enlargement_sqft() {
    return enlargement_sqft;
  }
  public void set_enlargement_sqft(java.math.BigDecimal enlargement_sqft) {
    this.enlargement_sqft = enlargement_sqft;
  }
  public fact_job_applications with_enlargement_sqft(java.math.BigDecimal enlargement_sqft) {
    this.enlargement_sqft = enlargement_sqft;
    return this;
  }
  private java.math.BigDecimal street_frontage;
  public java.math.BigDecimal get_street_frontage() {
    return street_frontage;
  }
  public void set_street_frontage(java.math.BigDecimal street_frontage) {
    this.street_frontage = street_frontage;
  }
  public fact_job_applications with_street_frontage(java.math.BigDecimal street_frontage) {
    this.street_frontage = street_frontage;
    return this;
  }
  private java.math.BigDecimal existing_no_of_stories;
  public java.math.BigDecimal get_existing_no_of_stories() {
    return existing_no_of_stories;
  }
  public void set_existing_no_of_stories(java.math.BigDecimal existing_no_of_stories) {
    this.existing_no_of_stories = existing_no_of_stories;
  }
  public fact_job_applications with_existing_no_of_stories(java.math.BigDecimal existing_no_of_stories) {
    this.existing_no_of_stories = existing_no_of_stories;
    return this;
  }
  private java.math.BigDecimal proposed_no_of_stories;
  public java.math.BigDecimal get_proposed_no_of_stories() {
    return proposed_no_of_stories;
  }
  public void set_proposed_no_of_stories(java.math.BigDecimal proposed_no_of_stories) {
    this.proposed_no_of_stories = proposed_no_of_stories;
  }
  public fact_job_applications with_proposed_no_of_stories(java.math.BigDecimal proposed_no_of_stories) {
    this.proposed_no_of_stories = proposed_no_of_stories;
    return this;
  }
  private java.math.BigDecimal existing_height;
  public java.math.BigDecimal get_existing_height() {
    return existing_height;
  }
  public void set_existing_height(java.math.BigDecimal existing_height) {
    this.existing_height = existing_height;
  }
  public fact_job_applications with_existing_height(java.math.BigDecimal existing_height) {
    this.existing_height = existing_height;
    return this;
  }
  private java.math.BigDecimal proposed_height;
  public java.math.BigDecimal get_proposed_height() {
    return proposed_height;
  }
  public void set_proposed_height(java.math.BigDecimal proposed_height) {
    this.proposed_height = proposed_height;
  }
  public fact_job_applications with_proposed_height(java.math.BigDecimal proposed_height) {
    this.proposed_height = proposed_height;
    return this;
  }
  private Integer existing_dwelling_units;
  public Integer get_existing_dwelling_units() {
    return existing_dwelling_units;
  }
  public void set_existing_dwelling_units(Integer existing_dwelling_units) {
    this.existing_dwelling_units = existing_dwelling_units;
  }
  public fact_job_applications with_existing_dwelling_units(Integer existing_dwelling_units) {
    this.existing_dwelling_units = existing_dwelling_units;
    return this;
  }
  private Integer proposed_dwelling_units;
  public Integer get_proposed_dwelling_units() {
    return proposed_dwelling_units;
  }
  public void set_proposed_dwelling_units(Integer proposed_dwelling_units) {
    this.proposed_dwelling_units = proposed_dwelling_units;
  }
  public fact_job_applications with_proposed_dwelling_units(Integer proposed_dwelling_units) {
    this.proposed_dwelling_units = proposed_dwelling_units;
    return this;
  }
  private String existing_occupancy;
  public String get_existing_occupancy() {
    return existing_occupancy;
  }
  public void set_existing_occupancy(String existing_occupancy) {
    this.existing_occupancy = existing_occupancy;
  }
  public fact_job_applications with_existing_occupancy(String existing_occupancy) {
    this.existing_occupancy = existing_occupancy;
    return this;
  }
  private String proposed_occupancy;
  public String get_proposed_occupancy() {
    return proposed_occupancy;
  }
  public void set_proposed_occupancy(String proposed_occupancy) {
    this.proposed_occupancy = proposed_occupancy;
  }
  public fact_job_applications with_proposed_occupancy(String proposed_occupancy) {
    this.proposed_occupancy = proposed_occupancy;
    return this;
  }
  private String site_fill;
  public String get_site_fill() {
    return site_fill;
  }
  public void set_site_fill(String site_fill) {
    this.site_fill = site_fill;
  }
  public fact_job_applications with_site_fill(String site_fill) {
    this.site_fill = site_fill;
    return this;
  }
  private String zoning_dist1;
  public String get_zoning_dist1() {
    return zoning_dist1;
  }
  public void set_zoning_dist1(String zoning_dist1) {
    this.zoning_dist1 = zoning_dist1;
  }
  public fact_job_applications with_zoning_dist1(String zoning_dist1) {
    this.zoning_dist1 = zoning_dist1;
    return this;
  }
  private String zoning_dist2;
  public String get_zoning_dist2() {
    return zoning_dist2;
  }
  public void set_zoning_dist2(String zoning_dist2) {
    this.zoning_dist2 = zoning_dist2;
  }
  public fact_job_applications with_zoning_dist2(String zoning_dist2) {
    this.zoning_dist2 = zoning_dist2;
    return this;
  }
  private String zoning_dist3;
  public String get_zoning_dist3() {
    return zoning_dist3;
  }
  public void set_zoning_dist3(String zoning_dist3) {
    this.zoning_dist3 = zoning_dist3;
  }
  public fact_job_applications with_zoning_dist3(String zoning_dist3) {
    this.zoning_dist3 = zoning_dist3;
    return this;
  }
  private String special_district1;
  public String get_special_district1() {
    return special_district1;
  }
  public void set_special_district1(String special_district1) {
    this.special_district1 = special_district1;
  }
  public fact_job_applications with_special_district1(String special_district1) {
    this.special_district1 = special_district1;
    return this;
  }
  private String special_district2;
  public String get_special_district2() {
    return special_district2;
  }
  public void set_special_district2(String special_district2) {
    this.special_district2 = special_district2;
  }
  public fact_job_applications with_special_district2(String special_district2) {
    this.special_district2 = special_district2;
    return this;
  }
  private String owner_type;
  public String get_owner_type() {
    return owner_type;
  }
  public void set_owner_type(String owner_type) {
    this.owner_type = owner_type;
  }
  public fact_job_applications with_owner_type(String owner_type) {
    this.owner_type = owner_type;
    return this;
  }
  private String non_profit;
  public String get_non_profit() {
    return non_profit;
  }
  public void set_non_profit(String non_profit) {
    this.non_profit = non_profit;
  }
  public fact_job_applications with_non_profit(String non_profit) {
    this.non_profit = non_profit;
    return this;
  }
  private String owner_first_name;
  public String get_owner_first_name() {
    return owner_first_name;
  }
  public void set_owner_first_name(String owner_first_name) {
    this.owner_first_name = owner_first_name;
  }
  public fact_job_applications with_owner_first_name(String owner_first_name) {
    this.owner_first_name = owner_first_name;
    return this;
  }
  private String owner_last_name;
  public String get_owner_last_name() {
    return owner_last_name;
  }
  public void set_owner_last_name(String owner_last_name) {
    this.owner_last_name = owner_last_name;
  }
  public fact_job_applications with_owner_last_name(String owner_last_name) {
    this.owner_last_name = owner_last_name;
    return this;
  }
  private String owner_business_name;
  public String get_owner_business_name() {
    return owner_business_name;
  }
  public void set_owner_business_name(String owner_business_name) {
    this.owner_business_name = owner_business_name;
  }
  public fact_job_applications with_owner_business_name(String owner_business_name) {
    this.owner_business_name = owner_business_name;
    return this;
  }
  private String owner_house_number;
  public String get_owner_house_number() {
    return owner_house_number;
  }
  public void set_owner_house_number(String owner_house_number) {
    this.owner_house_number = owner_house_number;
  }
  public fact_job_applications with_owner_house_number(String owner_house_number) {
    this.owner_house_number = owner_house_number;
    return this;
  }
  private String owner_house_street_name;
  public String get_owner_house_street_name() {
    return owner_house_street_name;
  }
  public void set_owner_house_street_name(String owner_house_street_name) {
    this.owner_house_street_name = owner_house_street_name;
  }
  public fact_job_applications with_owner_house_street_name(String owner_house_street_name) {
    this.owner_house_street_name = owner_house_street_name;
    return this;
  }
  private String city;
  public String get_city() {
    return city;
  }
  public void set_city(String city) {
    this.city = city;
  }
  public fact_job_applications with_city(String city) {
    this.city = city;
    return this;
  }
  private String state;
  public String get_state() {
    return state;
  }
  public void set_state(String state) {
    this.state = state;
  }
  public fact_job_applications with_state(String state) {
    this.state = state;
    return this;
  }
  private String zip;
  public String get_zip() {
    return zip;
  }
  public void set_zip(String zip) {
    this.zip = zip;
  }
  public fact_job_applications with_zip(String zip) {
    this.zip = zip;
    return this;
  }
  private String owner_phone;
  public String get_owner_phone() {
    return owner_phone;
  }
  public void set_owner_phone(String owner_phone) {
    this.owner_phone = owner_phone;
  }
  public fact_job_applications with_owner_phone(String owner_phone) {
    this.owner_phone = owner_phone;
    return this;
  }
  private String job_description;
  public String get_job_description() {
    return job_description;
  }
  public void set_job_description(String job_description) {
    this.job_description = job_description;
  }
  public fact_job_applications with_job_description(String job_description) {
    this.job_description = job_description;
    return this;
  }
  private String dobrundate;
  public String get_dobrundate() {
    return dobrundate;
  }
  public void set_dobrundate(String dobrundate) {
    this.dobrundate = dobrundate;
  }
  public fact_job_applications with_dobrundate(String dobrundate) {
    this.dobrundate = dobrundate;
    return this;
  }
  private String job_s1_no;
  public String get_job_s1_no() {
    return job_s1_no;
  }
  public void set_job_s1_no(String job_s1_no) {
    this.job_s1_no = job_s1_no;
  }
  public fact_job_applications with_job_s1_no(String job_s1_no) {
    this.job_s1_no = job_s1_no;
    return this;
  }
  private java.math.BigDecimal total_construction_floor_area;
  public java.math.BigDecimal get_total_construction_floor_area() {
    return total_construction_floor_area;
  }
  public void set_total_construction_floor_area(java.math.BigDecimal total_construction_floor_area) {
    this.total_construction_floor_area = total_construction_floor_area;
  }
  public fact_job_applications with_total_construction_floor_area(java.math.BigDecimal total_construction_floor_area) {
    this.total_construction_floor_area = total_construction_floor_area;
    return this;
  }
  private String withdrawal_flag;
  public String get_withdrawal_flag() {
    return withdrawal_flag;
  }
  public void set_withdrawal_flag(String withdrawal_flag) {
    this.withdrawal_flag = withdrawal_flag;
  }
  public fact_job_applications with_withdrawal_flag(String withdrawal_flag) {
    this.withdrawal_flag = withdrawal_flag;
    return this;
  }
  private String signoff_date;
  public String get_signoff_date() {
    return signoff_date;
  }
  public void set_signoff_date(String signoff_date) {
    this.signoff_date = signoff_date;
  }
  public fact_job_applications with_signoff_date(String signoff_date) {
    this.signoff_date = signoff_date;
    return this;
  }
  private String special_action_status;
  public String get_special_action_status() {
    return special_action_status;
  }
  public void set_special_action_status(String special_action_status) {
    this.special_action_status = special_action_status;
  }
  public fact_job_applications with_special_action_status(String special_action_status) {
    this.special_action_status = special_action_status;
    return this;
  }
  private String special_action_date;
  public String get_special_action_date() {
    return special_action_date;
  }
  public void set_special_action_date(String special_action_date) {
    this.special_action_date = special_action_date;
  }
  public fact_job_applications with_special_action_date(String special_action_date) {
    this.special_action_date = special_action_date;
    return this;
  }
  private String building_class;
  public String get_building_class() {
    return building_class;
  }
  public void set_building_class(String building_class) {
    this.building_class = building_class;
  }
  public fact_job_applications with_building_class(String building_class) {
    this.building_class = building_class;
    return this;
  }
  private Integer job_no_good_count;
  public Integer get_job_no_good_count() {
    return job_no_good_count;
  }
  public void set_job_no_good_count(Integer job_no_good_count) {
    this.job_no_good_count = job_no_good_count;
  }
  public fact_job_applications with_job_no_good_count(Integer job_no_good_count) {
    this.job_no_good_count = job_no_good_count;
    return this;
  }
  private Double gis_latitude;
  public Double get_gis_latitude() {
    return gis_latitude;
  }
  public void set_gis_latitude(Double gis_latitude) {
    this.gis_latitude = gis_latitude;
  }
  public fact_job_applications with_gis_latitude(Double gis_latitude) {
    this.gis_latitude = gis_latitude;
    return this;
  }
  private Double gis_longitude;
  public Double get_gis_longitude() {
    return gis_longitude;
  }
  public void set_gis_longitude(Double gis_longitude) {
    this.gis_longitude = gis_longitude;
  }
  public fact_job_applications with_gis_longitude(Double gis_longitude) {
    this.gis_longitude = gis_longitude;
    return this;
  }
  private String gis_council_district;
  public String get_gis_council_district() {
    return gis_council_district;
  }
  public void set_gis_council_district(String gis_council_district) {
    this.gis_council_district = gis_council_district;
  }
  public fact_job_applications with_gis_council_district(String gis_council_district) {
    this.gis_council_district = gis_council_district;
    return this;
  }
  private String gis_census_tract;
  public String get_gis_census_tract() {
    return gis_census_tract;
  }
  public void set_gis_census_tract(String gis_census_tract) {
    this.gis_census_tract = gis_census_tract;
  }
  public fact_job_applications with_gis_census_tract(String gis_census_tract) {
    this.gis_census_tract = gis_census_tract;
    return this;
  }
  private String gis_nta_name;
  public String get_gis_nta_name() {
    return gis_nta_name;
  }
  public void set_gis_nta_name(String gis_nta_name) {
    this.gis_nta_name = gis_nta_name;
  }
  public fact_job_applications with_gis_nta_name(String gis_nta_name) {
    this.gis_nta_name = gis_nta_name;
    return this;
  }
  private String gis_bin;
  public String get_gis_bin() {
    return gis_bin;
  }
  public void set_gis_bin(String gis_bin) {
    this.gis_bin = gis_bin;
  }
  public fact_job_applications with_gis_bin(String gis_bin) {
    this.gis_bin = gis_bin;
    return this;
  }
  private java.sql.Timestamp created_at;
  public java.sql.Timestamp get_created_at() {
    return created_at;
  }
  public void set_created_at(java.sql.Timestamp created_at) {
    this.created_at = created_at;
  }
  public fact_job_applications with_created_at(java.sql.Timestamp created_at) {
    this.created_at = created_at;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof fact_job_applications)) {
      return false;
    }
    fact_job_applications that = (fact_job_applications) o;
    boolean equal = true;
    equal = equal && (this.fact_id == null ? that.fact_id == null : this.fact_id.equals(that.fact_id));
    equal = equal && (this.job_number == null ? that.job_number == null : this.job_number.equals(that.job_number));
    equal = equal && (this.doc_number == null ? that.doc_number == null : this.doc_number.equals(that.doc_number));
    equal = equal && (this.borough == null ? that.borough == null : this.borough.equals(that.borough));
    equal = equal && (this.house_number == null ? that.house_number == null : this.house_number.equals(that.house_number));
    equal = equal && (this.street_name == null ? that.street_name == null : this.street_name.equals(that.street_name));
    equal = equal && (this.block == null ? that.block == null : this.block.equals(that.block));
    equal = equal && (this.lot == null ? that.lot == null : this.lot.equals(that.lot));
    equal = equal && (this.bin_number == null ? that.bin_number == null : this.bin_number.equals(that.bin_number));
    equal = equal && (this.job_type == null ? that.job_type == null : this.job_type.equals(that.job_type));
    equal = equal && (this.job_status == null ? that.job_status == null : this.job_status.equals(that.job_status));
    equal = equal && (this.job_status_descr == null ? that.job_status_descr == null : this.job_status_descr.equals(that.job_status_descr));
    equal = equal && (this.latest_action_date == null ? that.latest_action_date == null : this.latest_action_date.equals(that.latest_action_date));
    equal = equal && (this.building_type == null ? that.building_type == null : this.building_type.equals(that.building_type));
    equal = equal && (this.community_board == null ? that.community_board == null : this.community_board.equals(that.community_board));
    equal = equal && (this.cluster == null ? that.cluster == null : this.cluster.equals(that.cluster));
    equal = equal && (this.landmarked == null ? that.landmarked == null : this.landmarked.equals(that.landmarked));
    equal = equal && (this.adult_estab == null ? that.adult_estab == null : this.adult_estab.equals(that.adult_estab));
    equal = equal && (this.loft_board == null ? that.loft_board == null : this.loft_board.equals(that.loft_board));
    equal = equal && (this.city_owned == null ? that.city_owned == null : this.city_owned.equals(that.city_owned));
    equal = equal && (this.little_e == null ? that.little_e == null : this.little_e.equals(that.little_e));
    equal = equal && (this.pc_filed == null ? that.pc_filed == null : this.pc_filed.equals(that.pc_filed));
    equal = equal && (this.efiling_filed == null ? that.efiling_filed == null : this.efiling_filed.equals(that.efiling_filed));
    equal = equal && (this.plumbing == null ? that.plumbing == null : this.plumbing.equals(that.plumbing));
    equal = equal && (this.mechanical == null ? that.mechanical == null : this.mechanical.equals(that.mechanical));
    equal = equal && (this.boiler == null ? that.boiler == null : this.boiler.equals(that.boiler));
    equal = equal && (this.fuel_burning == null ? that.fuel_burning == null : this.fuel_burning.equals(that.fuel_burning));
    equal = equal && (this.fuel_storage == null ? that.fuel_storage == null : this.fuel_storage.equals(that.fuel_storage));
    equal = equal && (this.standpipe == null ? that.standpipe == null : this.standpipe.equals(that.standpipe));
    equal = equal && (this.sprinkler == null ? that.sprinkler == null : this.sprinkler.equals(that.sprinkler));
    equal = equal && (this.fire_alarm == null ? that.fire_alarm == null : this.fire_alarm.equals(that.fire_alarm));
    equal = equal && (this.equipment == null ? that.equipment == null : this.equipment.equals(that.equipment));
    equal = equal && (this.fire_suppression == null ? that.fire_suppression == null : this.fire_suppression.equals(that.fire_suppression));
    equal = equal && (this.curb_cut == null ? that.curb_cut == null : this.curb_cut.equals(that.curb_cut));
    equal = equal && (this.other == null ? that.other == null : this.other.equals(that.other));
    equal = equal && (this.other_description == null ? that.other_description == null : this.other_description.equals(that.other_description));
    equal = equal && (this.applicant_first_name == null ? that.applicant_first_name == null : this.applicant_first_name.equals(that.applicant_first_name));
    equal = equal && (this.applicant_last_name == null ? that.applicant_last_name == null : this.applicant_last_name.equals(that.applicant_last_name));
    equal = equal && (this.applicant_professional_title == null ? that.applicant_professional_title == null : this.applicant_professional_title.equals(that.applicant_professional_title));
    equal = equal && (this.applicant_license == null ? that.applicant_license == null : this.applicant_license.equals(that.applicant_license));
    equal = equal && (this.professional_cert == null ? that.professional_cert == null : this.professional_cert.equals(that.professional_cert));
    equal = equal && (this.pre_filing_date == null ? that.pre_filing_date == null : this.pre_filing_date.equals(that.pre_filing_date));
    equal = equal && (this.paid == null ? that.paid == null : this.paid.equals(that.paid));
    equal = equal && (this.fully_paid == null ? that.fully_paid == null : this.fully_paid.equals(that.fully_paid));
    equal = equal && (this.assigned == null ? that.assigned == null : this.assigned.equals(that.assigned));
    equal = equal && (this.approved == null ? that.approved == null : this.approved.equals(that.approved));
    equal = equal && (this.fully_permitted == null ? that.fully_permitted == null : this.fully_permitted.equals(that.fully_permitted));
    equal = equal && (this.initial_cost == null ? that.initial_cost == null : this.initial_cost.equals(that.initial_cost));
    equal = equal && (this.total_est_fee == null ? that.total_est_fee == null : this.total_est_fee.equals(that.total_est_fee));
    equal = equal && (this.fee_status == null ? that.fee_status == null : this.fee_status.equals(that.fee_status));
    equal = equal && (this.existing_zoning_sqft == null ? that.existing_zoning_sqft == null : this.existing_zoning_sqft.equals(that.existing_zoning_sqft));
    equal = equal && (this.proposed_zoning_sqft == null ? that.proposed_zoning_sqft == null : this.proposed_zoning_sqft.equals(that.proposed_zoning_sqft));
    equal = equal && (this.horizontal_enlrgmt == null ? that.horizontal_enlrgmt == null : this.horizontal_enlrgmt.equals(that.horizontal_enlrgmt));
    equal = equal && (this.vertical_enlrgmt == null ? that.vertical_enlrgmt == null : this.vertical_enlrgmt.equals(that.vertical_enlrgmt));
    equal = equal && (this.enlargement_sqft == null ? that.enlargement_sqft == null : this.enlargement_sqft.equals(that.enlargement_sqft));
    equal = equal && (this.street_frontage == null ? that.street_frontage == null : this.street_frontage.equals(that.street_frontage));
    equal = equal && (this.existing_no_of_stories == null ? that.existing_no_of_stories == null : this.existing_no_of_stories.equals(that.existing_no_of_stories));
    equal = equal && (this.proposed_no_of_stories == null ? that.proposed_no_of_stories == null : this.proposed_no_of_stories.equals(that.proposed_no_of_stories));
    equal = equal && (this.existing_height == null ? that.existing_height == null : this.existing_height.equals(that.existing_height));
    equal = equal && (this.proposed_height == null ? that.proposed_height == null : this.proposed_height.equals(that.proposed_height));
    equal = equal && (this.existing_dwelling_units == null ? that.existing_dwelling_units == null : this.existing_dwelling_units.equals(that.existing_dwelling_units));
    equal = equal && (this.proposed_dwelling_units == null ? that.proposed_dwelling_units == null : this.proposed_dwelling_units.equals(that.proposed_dwelling_units));
    equal = equal && (this.existing_occupancy == null ? that.existing_occupancy == null : this.existing_occupancy.equals(that.existing_occupancy));
    equal = equal && (this.proposed_occupancy == null ? that.proposed_occupancy == null : this.proposed_occupancy.equals(that.proposed_occupancy));
    equal = equal && (this.site_fill == null ? that.site_fill == null : this.site_fill.equals(that.site_fill));
    equal = equal && (this.zoning_dist1 == null ? that.zoning_dist1 == null : this.zoning_dist1.equals(that.zoning_dist1));
    equal = equal && (this.zoning_dist2 == null ? that.zoning_dist2 == null : this.zoning_dist2.equals(that.zoning_dist2));
    equal = equal && (this.zoning_dist3 == null ? that.zoning_dist3 == null : this.zoning_dist3.equals(that.zoning_dist3));
    equal = equal && (this.special_district1 == null ? that.special_district1 == null : this.special_district1.equals(that.special_district1));
    equal = equal && (this.special_district2 == null ? that.special_district2 == null : this.special_district2.equals(that.special_district2));
    equal = equal && (this.owner_type == null ? that.owner_type == null : this.owner_type.equals(that.owner_type));
    equal = equal && (this.non_profit == null ? that.non_profit == null : this.non_profit.equals(that.non_profit));
    equal = equal && (this.owner_first_name == null ? that.owner_first_name == null : this.owner_first_name.equals(that.owner_first_name));
    equal = equal && (this.owner_last_name == null ? that.owner_last_name == null : this.owner_last_name.equals(that.owner_last_name));
    equal = equal && (this.owner_business_name == null ? that.owner_business_name == null : this.owner_business_name.equals(that.owner_business_name));
    equal = equal && (this.owner_house_number == null ? that.owner_house_number == null : this.owner_house_number.equals(that.owner_house_number));
    equal = equal && (this.owner_house_street_name == null ? that.owner_house_street_name == null : this.owner_house_street_name.equals(that.owner_house_street_name));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.zip == null ? that.zip == null : this.zip.equals(that.zip));
    equal = equal && (this.owner_phone == null ? that.owner_phone == null : this.owner_phone.equals(that.owner_phone));
    equal = equal && (this.job_description == null ? that.job_description == null : this.job_description.equals(that.job_description));
    equal = equal && (this.dobrundate == null ? that.dobrundate == null : this.dobrundate.equals(that.dobrundate));
    equal = equal && (this.job_s1_no == null ? that.job_s1_no == null : this.job_s1_no.equals(that.job_s1_no));
    equal = equal && (this.total_construction_floor_area == null ? that.total_construction_floor_area == null : this.total_construction_floor_area.equals(that.total_construction_floor_area));
    equal = equal && (this.withdrawal_flag == null ? that.withdrawal_flag == null : this.withdrawal_flag.equals(that.withdrawal_flag));
    equal = equal && (this.signoff_date == null ? that.signoff_date == null : this.signoff_date.equals(that.signoff_date));
    equal = equal && (this.special_action_status == null ? that.special_action_status == null : this.special_action_status.equals(that.special_action_status));
    equal = equal && (this.special_action_date == null ? that.special_action_date == null : this.special_action_date.equals(that.special_action_date));
    equal = equal && (this.building_class == null ? that.building_class == null : this.building_class.equals(that.building_class));
    equal = equal && (this.job_no_good_count == null ? that.job_no_good_count == null : this.job_no_good_count.equals(that.job_no_good_count));
    equal = equal && (this.gis_latitude == null ? that.gis_latitude == null : this.gis_latitude.equals(that.gis_latitude));
    equal = equal && (this.gis_longitude == null ? that.gis_longitude == null : this.gis_longitude.equals(that.gis_longitude));
    equal = equal && (this.gis_council_district == null ? that.gis_council_district == null : this.gis_council_district.equals(that.gis_council_district));
    equal = equal && (this.gis_census_tract == null ? that.gis_census_tract == null : this.gis_census_tract.equals(that.gis_census_tract));
    equal = equal && (this.gis_nta_name == null ? that.gis_nta_name == null : this.gis_nta_name.equals(that.gis_nta_name));
    equal = equal && (this.gis_bin == null ? that.gis_bin == null : this.gis_bin.equals(that.gis_bin));
    equal = equal && (this.created_at == null ? that.created_at == null : this.created_at.equals(that.created_at));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof fact_job_applications)) {
      return false;
    }
    fact_job_applications that = (fact_job_applications) o;
    boolean equal = true;
    equal = equal && (this.fact_id == null ? that.fact_id == null : this.fact_id.equals(that.fact_id));
    equal = equal && (this.job_number == null ? that.job_number == null : this.job_number.equals(that.job_number));
    equal = equal && (this.doc_number == null ? that.doc_number == null : this.doc_number.equals(that.doc_number));
    equal = equal && (this.borough == null ? that.borough == null : this.borough.equals(that.borough));
    equal = equal && (this.house_number == null ? that.house_number == null : this.house_number.equals(that.house_number));
    equal = equal && (this.street_name == null ? that.street_name == null : this.street_name.equals(that.street_name));
    equal = equal && (this.block == null ? that.block == null : this.block.equals(that.block));
    equal = equal && (this.lot == null ? that.lot == null : this.lot.equals(that.lot));
    equal = equal && (this.bin_number == null ? that.bin_number == null : this.bin_number.equals(that.bin_number));
    equal = equal && (this.job_type == null ? that.job_type == null : this.job_type.equals(that.job_type));
    equal = equal && (this.job_status == null ? that.job_status == null : this.job_status.equals(that.job_status));
    equal = equal && (this.job_status_descr == null ? that.job_status_descr == null : this.job_status_descr.equals(that.job_status_descr));
    equal = equal && (this.latest_action_date == null ? that.latest_action_date == null : this.latest_action_date.equals(that.latest_action_date));
    equal = equal && (this.building_type == null ? that.building_type == null : this.building_type.equals(that.building_type));
    equal = equal && (this.community_board == null ? that.community_board == null : this.community_board.equals(that.community_board));
    equal = equal && (this.cluster == null ? that.cluster == null : this.cluster.equals(that.cluster));
    equal = equal && (this.landmarked == null ? that.landmarked == null : this.landmarked.equals(that.landmarked));
    equal = equal && (this.adult_estab == null ? that.adult_estab == null : this.adult_estab.equals(that.adult_estab));
    equal = equal && (this.loft_board == null ? that.loft_board == null : this.loft_board.equals(that.loft_board));
    equal = equal && (this.city_owned == null ? that.city_owned == null : this.city_owned.equals(that.city_owned));
    equal = equal && (this.little_e == null ? that.little_e == null : this.little_e.equals(that.little_e));
    equal = equal && (this.pc_filed == null ? that.pc_filed == null : this.pc_filed.equals(that.pc_filed));
    equal = equal && (this.efiling_filed == null ? that.efiling_filed == null : this.efiling_filed.equals(that.efiling_filed));
    equal = equal && (this.plumbing == null ? that.plumbing == null : this.plumbing.equals(that.plumbing));
    equal = equal && (this.mechanical == null ? that.mechanical == null : this.mechanical.equals(that.mechanical));
    equal = equal && (this.boiler == null ? that.boiler == null : this.boiler.equals(that.boiler));
    equal = equal && (this.fuel_burning == null ? that.fuel_burning == null : this.fuel_burning.equals(that.fuel_burning));
    equal = equal && (this.fuel_storage == null ? that.fuel_storage == null : this.fuel_storage.equals(that.fuel_storage));
    equal = equal && (this.standpipe == null ? that.standpipe == null : this.standpipe.equals(that.standpipe));
    equal = equal && (this.sprinkler == null ? that.sprinkler == null : this.sprinkler.equals(that.sprinkler));
    equal = equal && (this.fire_alarm == null ? that.fire_alarm == null : this.fire_alarm.equals(that.fire_alarm));
    equal = equal && (this.equipment == null ? that.equipment == null : this.equipment.equals(that.equipment));
    equal = equal && (this.fire_suppression == null ? that.fire_suppression == null : this.fire_suppression.equals(that.fire_suppression));
    equal = equal && (this.curb_cut == null ? that.curb_cut == null : this.curb_cut.equals(that.curb_cut));
    equal = equal && (this.other == null ? that.other == null : this.other.equals(that.other));
    equal = equal && (this.other_description == null ? that.other_description == null : this.other_description.equals(that.other_description));
    equal = equal && (this.applicant_first_name == null ? that.applicant_first_name == null : this.applicant_first_name.equals(that.applicant_first_name));
    equal = equal && (this.applicant_last_name == null ? that.applicant_last_name == null : this.applicant_last_name.equals(that.applicant_last_name));
    equal = equal && (this.applicant_professional_title == null ? that.applicant_professional_title == null : this.applicant_professional_title.equals(that.applicant_professional_title));
    equal = equal && (this.applicant_license == null ? that.applicant_license == null : this.applicant_license.equals(that.applicant_license));
    equal = equal && (this.professional_cert == null ? that.professional_cert == null : this.professional_cert.equals(that.professional_cert));
    equal = equal && (this.pre_filing_date == null ? that.pre_filing_date == null : this.pre_filing_date.equals(that.pre_filing_date));
    equal = equal && (this.paid == null ? that.paid == null : this.paid.equals(that.paid));
    equal = equal && (this.fully_paid == null ? that.fully_paid == null : this.fully_paid.equals(that.fully_paid));
    equal = equal && (this.assigned == null ? that.assigned == null : this.assigned.equals(that.assigned));
    equal = equal && (this.approved == null ? that.approved == null : this.approved.equals(that.approved));
    equal = equal && (this.fully_permitted == null ? that.fully_permitted == null : this.fully_permitted.equals(that.fully_permitted));
    equal = equal && (this.initial_cost == null ? that.initial_cost == null : this.initial_cost.equals(that.initial_cost));
    equal = equal && (this.total_est_fee == null ? that.total_est_fee == null : this.total_est_fee.equals(that.total_est_fee));
    equal = equal && (this.fee_status == null ? that.fee_status == null : this.fee_status.equals(that.fee_status));
    equal = equal && (this.existing_zoning_sqft == null ? that.existing_zoning_sqft == null : this.existing_zoning_sqft.equals(that.existing_zoning_sqft));
    equal = equal && (this.proposed_zoning_sqft == null ? that.proposed_zoning_sqft == null : this.proposed_zoning_sqft.equals(that.proposed_zoning_sqft));
    equal = equal && (this.horizontal_enlrgmt == null ? that.horizontal_enlrgmt == null : this.horizontal_enlrgmt.equals(that.horizontal_enlrgmt));
    equal = equal && (this.vertical_enlrgmt == null ? that.vertical_enlrgmt == null : this.vertical_enlrgmt.equals(that.vertical_enlrgmt));
    equal = equal && (this.enlargement_sqft == null ? that.enlargement_sqft == null : this.enlargement_sqft.equals(that.enlargement_sqft));
    equal = equal && (this.street_frontage == null ? that.street_frontage == null : this.street_frontage.equals(that.street_frontage));
    equal = equal && (this.existing_no_of_stories == null ? that.existing_no_of_stories == null : this.existing_no_of_stories.equals(that.existing_no_of_stories));
    equal = equal && (this.proposed_no_of_stories == null ? that.proposed_no_of_stories == null : this.proposed_no_of_stories.equals(that.proposed_no_of_stories));
    equal = equal && (this.existing_height == null ? that.existing_height == null : this.existing_height.equals(that.existing_height));
    equal = equal && (this.proposed_height == null ? that.proposed_height == null : this.proposed_height.equals(that.proposed_height));
    equal = equal && (this.existing_dwelling_units == null ? that.existing_dwelling_units == null : this.existing_dwelling_units.equals(that.existing_dwelling_units));
    equal = equal && (this.proposed_dwelling_units == null ? that.proposed_dwelling_units == null : this.proposed_dwelling_units.equals(that.proposed_dwelling_units));
    equal = equal && (this.existing_occupancy == null ? that.existing_occupancy == null : this.existing_occupancy.equals(that.existing_occupancy));
    equal = equal && (this.proposed_occupancy == null ? that.proposed_occupancy == null : this.proposed_occupancy.equals(that.proposed_occupancy));
    equal = equal && (this.site_fill == null ? that.site_fill == null : this.site_fill.equals(that.site_fill));
    equal = equal && (this.zoning_dist1 == null ? that.zoning_dist1 == null : this.zoning_dist1.equals(that.zoning_dist1));
    equal = equal && (this.zoning_dist2 == null ? that.zoning_dist2 == null : this.zoning_dist2.equals(that.zoning_dist2));
    equal = equal && (this.zoning_dist3 == null ? that.zoning_dist3 == null : this.zoning_dist3.equals(that.zoning_dist3));
    equal = equal && (this.special_district1 == null ? that.special_district1 == null : this.special_district1.equals(that.special_district1));
    equal = equal && (this.special_district2 == null ? that.special_district2 == null : this.special_district2.equals(that.special_district2));
    equal = equal && (this.owner_type == null ? that.owner_type == null : this.owner_type.equals(that.owner_type));
    equal = equal && (this.non_profit == null ? that.non_profit == null : this.non_profit.equals(that.non_profit));
    equal = equal && (this.owner_first_name == null ? that.owner_first_name == null : this.owner_first_name.equals(that.owner_first_name));
    equal = equal && (this.owner_last_name == null ? that.owner_last_name == null : this.owner_last_name.equals(that.owner_last_name));
    equal = equal && (this.owner_business_name == null ? that.owner_business_name == null : this.owner_business_name.equals(that.owner_business_name));
    equal = equal && (this.owner_house_number == null ? that.owner_house_number == null : this.owner_house_number.equals(that.owner_house_number));
    equal = equal && (this.owner_house_street_name == null ? that.owner_house_street_name == null : this.owner_house_street_name.equals(that.owner_house_street_name));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.zip == null ? that.zip == null : this.zip.equals(that.zip));
    equal = equal && (this.owner_phone == null ? that.owner_phone == null : this.owner_phone.equals(that.owner_phone));
    equal = equal && (this.job_description == null ? that.job_description == null : this.job_description.equals(that.job_description));
    equal = equal && (this.dobrundate == null ? that.dobrundate == null : this.dobrundate.equals(that.dobrundate));
    equal = equal && (this.job_s1_no == null ? that.job_s1_no == null : this.job_s1_no.equals(that.job_s1_no));
    equal = equal && (this.total_construction_floor_area == null ? that.total_construction_floor_area == null : this.total_construction_floor_area.equals(that.total_construction_floor_area));
    equal = equal && (this.withdrawal_flag == null ? that.withdrawal_flag == null : this.withdrawal_flag.equals(that.withdrawal_flag));
    equal = equal && (this.signoff_date == null ? that.signoff_date == null : this.signoff_date.equals(that.signoff_date));
    equal = equal && (this.special_action_status == null ? that.special_action_status == null : this.special_action_status.equals(that.special_action_status));
    equal = equal && (this.special_action_date == null ? that.special_action_date == null : this.special_action_date.equals(that.special_action_date));
    equal = equal && (this.building_class == null ? that.building_class == null : this.building_class.equals(that.building_class));
    equal = equal && (this.job_no_good_count == null ? that.job_no_good_count == null : this.job_no_good_count.equals(that.job_no_good_count));
    equal = equal && (this.gis_latitude == null ? that.gis_latitude == null : this.gis_latitude.equals(that.gis_latitude));
    equal = equal && (this.gis_longitude == null ? that.gis_longitude == null : this.gis_longitude.equals(that.gis_longitude));
    equal = equal && (this.gis_council_district == null ? that.gis_council_district == null : this.gis_council_district.equals(that.gis_council_district));
    equal = equal && (this.gis_census_tract == null ? that.gis_census_tract == null : this.gis_census_tract.equals(that.gis_census_tract));
    equal = equal && (this.gis_nta_name == null ? that.gis_nta_name == null : this.gis_nta_name.equals(that.gis_nta_name));
    equal = equal && (this.gis_bin == null ? that.gis_bin == null : this.gis_bin.equals(that.gis_bin));
    equal = equal && (this.created_at == null ? that.created_at == null : this.created_at.equals(that.created_at));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.fact_id = JdbcWritableBridge.readLong(1, __dbResults);
    this.job_number = JdbcWritableBridge.readLong(2, __dbResults);
    this.doc_number = JdbcWritableBridge.readInteger(3, __dbResults);
    this.borough = JdbcWritableBridge.readString(4, __dbResults);
    this.house_number = JdbcWritableBridge.readString(5, __dbResults);
    this.street_name = JdbcWritableBridge.readString(6, __dbResults);
    this.block = JdbcWritableBridge.readInteger(7, __dbResults);
    this.lot = JdbcWritableBridge.readInteger(8, __dbResults);
    this.bin_number = JdbcWritableBridge.readLong(9, __dbResults);
    this.job_type = JdbcWritableBridge.readString(10, __dbResults);
    this.job_status = JdbcWritableBridge.readString(11, __dbResults);
    this.job_status_descr = JdbcWritableBridge.readString(12, __dbResults);
    this.latest_action_date = JdbcWritableBridge.readString(13, __dbResults);
    this.building_type = JdbcWritableBridge.readString(14, __dbResults);
    this.community_board = JdbcWritableBridge.readString(15, __dbResults);
    this.cluster = JdbcWritableBridge.readString(16, __dbResults);
    this.landmarked = JdbcWritableBridge.readString(17, __dbResults);
    this.adult_estab = JdbcWritableBridge.readString(18, __dbResults);
    this.loft_board = JdbcWritableBridge.readString(19, __dbResults);
    this.city_owned = JdbcWritableBridge.readString(20, __dbResults);
    this.little_e = JdbcWritableBridge.readString(21, __dbResults);
    this.pc_filed = JdbcWritableBridge.readString(22, __dbResults);
    this.efiling_filed = JdbcWritableBridge.readString(23, __dbResults);
    this.plumbing = JdbcWritableBridge.readString(24, __dbResults);
    this.mechanical = JdbcWritableBridge.readString(25, __dbResults);
    this.boiler = JdbcWritableBridge.readString(26, __dbResults);
    this.fuel_burning = JdbcWritableBridge.readString(27, __dbResults);
    this.fuel_storage = JdbcWritableBridge.readString(28, __dbResults);
    this.standpipe = JdbcWritableBridge.readString(29, __dbResults);
    this.sprinkler = JdbcWritableBridge.readString(30, __dbResults);
    this.fire_alarm = JdbcWritableBridge.readString(31, __dbResults);
    this.equipment = JdbcWritableBridge.readString(32, __dbResults);
    this.fire_suppression = JdbcWritableBridge.readString(33, __dbResults);
    this.curb_cut = JdbcWritableBridge.readString(34, __dbResults);
    this.other = JdbcWritableBridge.readString(35, __dbResults);
    this.other_description = JdbcWritableBridge.readString(36, __dbResults);
    this.applicant_first_name = JdbcWritableBridge.readString(37, __dbResults);
    this.applicant_last_name = JdbcWritableBridge.readString(38, __dbResults);
    this.applicant_professional_title = JdbcWritableBridge.readString(39, __dbResults);
    this.applicant_license = JdbcWritableBridge.readString(40, __dbResults);
    this.professional_cert = JdbcWritableBridge.readString(41, __dbResults);
    this.pre_filing_date = JdbcWritableBridge.readString(42, __dbResults);
    this.paid = JdbcWritableBridge.readString(43, __dbResults);
    this.fully_paid = JdbcWritableBridge.readString(44, __dbResults);
    this.assigned = JdbcWritableBridge.readString(45, __dbResults);
    this.approved = JdbcWritableBridge.readString(46, __dbResults);
    this.fully_permitted = JdbcWritableBridge.readString(47, __dbResults);
    this.initial_cost = JdbcWritableBridge.readBigDecimal(48, __dbResults);
    this.total_est_fee = JdbcWritableBridge.readBigDecimal(49, __dbResults);
    this.fee_status = JdbcWritableBridge.readString(50, __dbResults);
    this.existing_zoning_sqft = JdbcWritableBridge.readBigDecimal(51, __dbResults);
    this.proposed_zoning_sqft = JdbcWritableBridge.readBigDecimal(52, __dbResults);
    this.horizontal_enlrgmt = JdbcWritableBridge.readString(53, __dbResults);
    this.vertical_enlrgmt = JdbcWritableBridge.readString(54, __dbResults);
    this.enlargement_sqft = JdbcWritableBridge.readBigDecimal(55, __dbResults);
    this.street_frontage = JdbcWritableBridge.readBigDecimal(56, __dbResults);
    this.existing_no_of_stories = JdbcWritableBridge.readBigDecimal(57, __dbResults);
    this.proposed_no_of_stories = JdbcWritableBridge.readBigDecimal(58, __dbResults);
    this.existing_height = JdbcWritableBridge.readBigDecimal(59, __dbResults);
    this.proposed_height = JdbcWritableBridge.readBigDecimal(60, __dbResults);
    this.existing_dwelling_units = JdbcWritableBridge.readInteger(61, __dbResults);
    this.proposed_dwelling_units = JdbcWritableBridge.readInteger(62, __dbResults);
    this.existing_occupancy = JdbcWritableBridge.readString(63, __dbResults);
    this.proposed_occupancy = JdbcWritableBridge.readString(64, __dbResults);
    this.site_fill = JdbcWritableBridge.readString(65, __dbResults);
    this.zoning_dist1 = JdbcWritableBridge.readString(66, __dbResults);
    this.zoning_dist2 = JdbcWritableBridge.readString(67, __dbResults);
    this.zoning_dist3 = JdbcWritableBridge.readString(68, __dbResults);
    this.special_district1 = JdbcWritableBridge.readString(69, __dbResults);
    this.special_district2 = JdbcWritableBridge.readString(70, __dbResults);
    this.owner_type = JdbcWritableBridge.readString(71, __dbResults);
    this.non_profit = JdbcWritableBridge.readString(72, __dbResults);
    this.owner_first_name = JdbcWritableBridge.readString(73, __dbResults);
    this.owner_last_name = JdbcWritableBridge.readString(74, __dbResults);
    this.owner_business_name = JdbcWritableBridge.readString(75, __dbResults);
    this.owner_house_number = JdbcWritableBridge.readString(76, __dbResults);
    this.owner_house_street_name = JdbcWritableBridge.readString(77, __dbResults);
    this.city = JdbcWritableBridge.readString(78, __dbResults);
    this.state = JdbcWritableBridge.readString(79, __dbResults);
    this.zip = JdbcWritableBridge.readString(80, __dbResults);
    this.owner_phone = JdbcWritableBridge.readString(81, __dbResults);
    this.job_description = JdbcWritableBridge.readString(82, __dbResults);
    this.dobrundate = JdbcWritableBridge.readString(83, __dbResults);
    this.job_s1_no = JdbcWritableBridge.readString(84, __dbResults);
    this.total_construction_floor_area = JdbcWritableBridge.readBigDecimal(85, __dbResults);
    this.withdrawal_flag = JdbcWritableBridge.readString(86, __dbResults);
    this.signoff_date = JdbcWritableBridge.readString(87, __dbResults);
    this.special_action_status = JdbcWritableBridge.readString(88, __dbResults);
    this.special_action_date = JdbcWritableBridge.readString(89, __dbResults);
    this.building_class = JdbcWritableBridge.readString(90, __dbResults);
    this.job_no_good_count = JdbcWritableBridge.readInteger(91, __dbResults);
    this.gis_latitude = JdbcWritableBridge.readDouble(92, __dbResults);
    this.gis_longitude = JdbcWritableBridge.readDouble(93, __dbResults);
    this.gis_council_district = JdbcWritableBridge.readString(94, __dbResults);
    this.gis_census_tract = JdbcWritableBridge.readString(95, __dbResults);
    this.gis_nta_name = JdbcWritableBridge.readString(96, __dbResults);
    this.gis_bin = JdbcWritableBridge.readString(97, __dbResults);
    this.created_at = JdbcWritableBridge.readTimestamp(98, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.fact_id = JdbcWritableBridge.readLong(1, __dbResults);
    this.job_number = JdbcWritableBridge.readLong(2, __dbResults);
    this.doc_number = JdbcWritableBridge.readInteger(3, __dbResults);
    this.borough = JdbcWritableBridge.readString(4, __dbResults);
    this.house_number = JdbcWritableBridge.readString(5, __dbResults);
    this.street_name = JdbcWritableBridge.readString(6, __dbResults);
    this.block = JdbcWritableBridge.readInteger(7, __dbResults);
    this.lot = JdbcWritableBridge.readInteger(8, __dbResults);
    this.bin_number = JdbcWritableBridge.readLong(9, __dbResults);
    this.job_type = JdbcWritableBridge.readString(10, __dbResults);
    this.job_status = JdbcWritableBridge.readString(11, __dbResults);
    this.job_status_descr = JdbcWritableBridge.readString(12, __dbResults);
    this.latest_action_date = JdbcWritableBridge.readString(13, __dbResults);
    this.building_type = JdbcWritableBridge.readString(14, __dbResults);
    this.community_board = JdbcWritableBridge.readString(15, __dbResults);
    this.cluster = JdbcWritableBridge.readString(16, __dbResults);
    this.landmarked = JdbcWritableBridge.readString(17, __dbResults);
    this.adult_estab = JdbcWritableBridge.readString(18, __dbResults);
    this.loft_board = JdbcWritableBridge.readString(19, __dbResults);
    this.city_owned = JdbcWritableBridge.readString(20, __dbResults);
    this.little_e = JdbcWritableBridge.readString(21, __dbResults);
    this.pc_filed = JdbcWritableBridge.readString(22, __dbResults);
    this.efiling_filed = JdbcWritableBridge.readString(23, __dbResults);
    this.plumbing = JdbcWritableBridge.readString(24, __dbResults);
    this.mechanical = JdbcWritableBridge.readString(25, __dbResults);
    this.boiler = JdbcWritableBridge.readString(26, __dbResults);
    this.fuel_burning = JdbcWritableBridge.readString(27, __dbResults);
    this.fuel_storage = JdbcWritableBridge.readString(28, __dbResults);
    this.standpipe = JdbcWritableBridge.readString(29, __dbResults);
    this.sprinkler = JdbcWritableBridge.readString(30, __dbResults);
    this.fire_alarm = JdbcWritableBridge.readString(31, __dbResults);
    this.equipment = JdbcWritableBridge.readString(32, __dbResults);
    this.fire_suppression = JdbcWritableBridge.readString(33, __dbResults);
    this.curb_cut = JdbcWritableBridge.readString(34, __dbResults);
    this.other = JdbcWritableBridge.readString(35, __dbResults);
    this.other_description = JdbcWritableBridge.readString(36, __dbResults);
    this.applicant_first_name = JdbcWritableBridge.readString(37, __dbResults);
    this.applicant_last_name = JdbcWritableBridge.readString(38, __dbResults);
    this.applicant_professional_title = JdbcWritableBridge.readString(39, __dbResults);
    this.applicant_license = JdbcWritableBridge.readString(40, __dbResults);
    this.professional_cert = JdbcWritableBridge.readString(41, __dbResults);
    this.pre_filing_date = JdbcWritableBridge.readString(42, __dbResults);
    this.paid = JdbcWritableBridge.readString(43, __dbResults);
    this.fully_paid = JdbcWritableBridge.readString(44, __dbResults);
    this.assigned = JdbcWritableBridge.readString(45, __dbResults);
    this.approved = JdbcWritableBridge.readString(46, __dbResults);
    this.fully_permitted = JdbcWritableBridge.readString(47, __dbResults);
    this.initial_cost = JdbcWritableBridge.readBigDecimal(48, __dbResults);
    this.total_est_fee = JdbcWritableBridge.readBigDecimal(49, __dbResults);
    this.fee_status = JdbcWritableBridge.readString(50, __dbResults);
    this.existing_zoning_sqft = JdbcWritableBridge.readBigDecimal(51, __dbResults);
    this.proposed_zoning_sqft = JdbcWritableBridge.readBigDecimal(52, __dbResults);
    this.horizontal_enlrgmt = JdbcWritableBridge.readString(53, __dbResults);
    this.vertical_enlrgmt = JdbcWritableBridge.readString(54, __dbResults);
    this.enlargement_sqft = JdbcWritableBridge.readBigDecimal(55, __dbResults);
    this.street_frontage = JdbcWritableBridge.readBigDecimal(56, __dbResults);
    this.existing_no_of_stories = JdbcWritableBridge.readBigDecimal(57, __dbResults);
    this.proposed_no_of_stories = JdbcWritableBridge.readBigDecimal(58, __dbResults);
    this.existing_height = JdbcWritableBridge.readBigDecimal(59, __dbResults);
    this.proposed_height = JdbcWritableBridge.readBigDecimal(60, __dbResults);
    this.existing_dwelling_units = JdbcWritableBridge.readInteger(61, __dbResults);
    this.proposed_dwelling_units = JdbcWritableBridge.readInteger(62, __dbResults);
    this.existing_occupancy = JdbcWritableBridge.readString(63, __dbResults);
    this.proposed_occupancy = JdbcWritableBridge.readString(64, __dbResults);
    this.site_fill = JdbcWritableBridge.readString(65, __dbResults);
    this.zoning_dist1 = JdbcWritableBridge.readString(66, __dbResults);
    this.zoning_dist2 = JdbcWritableBridge.readString(67, __dbResults);
    this.zoning_dist3 = JdbcWritableBridge.readString(68, __dbResults);
    this.special_district1 = JdbcWritableBridge.readString(69, __dbResults);
    this.special_district2 = JdbcWritableBridge.readString(70, __dbResults);
    this.owner_type = JdbcWritableBridge.readString(71, __dbResults);
    this.non_profit = JdbcWritableBridge.readString(72, __dbResults);
    this.owner_first_name = JdbcWritableBridge.readString(73, __dbResults);
    this.owner_last_name = JdbcWritableBridge.readString(74, __dbResults);
    this.owner_business_name = JdbcWritableBridge.readString(75, __dbResults);
    this.owner_house_number = JdbcWritableBridge.readString(76, __dbResults);
    this.owner_house_street_name = JdbcWritableBridge.readString(77, __dbResults);
    this.city = JdbcWritableBridge.readString(78, __dbResults);
    this.state = JdbcWritableBridge.readString(79, __dbResults);
    this.zip = JdbcWritableBridge.readString(80, __dbResults);
    this.owner_phone = JdbcWritableBridge.readString(81, __dbResults);
    this.job_description = JdbcWritableBridge.readString(82, __dbResults);
    this.dobrundate = JdbcWritableBridge.readString(83, __dbResults);
    this.job_s1_no = JdbcWritableBridge.readString(84, __dbResults);
    this.total_construction_floor_area = JdbcWritableBridge.readBigDecimal(85, __dbResults);
    this.withdrawal_flag = JdbcWritableBridge.readString(86, __dbResults);
    this.signoff_date = JdbcWritableBridge.readString(87, __dbResults);
    this.special_action_status = JdbcWritableBridge.readString(88, __dbResults);
    this.special_action_date = JdbcWritableBridge.readString(89, __dbResults);
    this.building_class = JdbcWritableBridge.readString(90, __dbResults);
    this.job_no_good_count = JdbcWritableBridge.readInteger(91, __dbResults);
    this.gis_latitude = JdbcWritableBridge.readDouble(92, __dbResults);
    this.gis_longitude = JdbcWritableBridge.readDouble(93, __dbResults);
    this.gis_council_district = JdbcWritableBridge.readString(94, __dbResults);
    this.gis_census_tract = JdbcWritableBridge.readString(95, __dbResults);
    this.gis_nta_name = JdbcWritableBridge.readString(96, __dbResults);
    this.gis_bin = JdbcWritableBridge.readString(97, __dbResults);
    this.created_at = JdbcWritableBridge.readTimestamp(98, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeLong(fact_id, 1 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(job_number, 2 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeInteger(doc_number, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(borough, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(house_number, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(street_name, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(block, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(lot, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeLong(bin_number, 9 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeString(job_type, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_status, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_status_descr, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(latest_action_date, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(building_type, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(community_board, 15 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(cluster, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(landmarked, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(adult_estab, 18 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(loft_board, 19 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city_owned, 20 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(little_e, 21 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pc_filed, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(efiling_filed, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(plumbing, 24 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(mechanical, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(boiler, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fuel_burning, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fuel_storage, 28 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(standpipe, 29 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sprinkler, 30 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fire_alarm, 31 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(equipment, 32 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fire_suppression, 33 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(curb_cut, 34 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(other, 35 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(other_description, 36 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_first_name, 37 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_last_name, 38 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_professional_title, 39 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_license, 40 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(professional_cert, 41 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pre_filing_date, 42 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(paid, 43 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fully_paid, 44 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(assigned, 45 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(approved, 46 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fully_permitted, 47 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(initial_cost, 48 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_est_fee, 49 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(fee_status, 50 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_zoning_sqft, 51 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_zoning_sqft, 52 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(horizontal_enlrgmt, 53 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(vertical_enlrgmt, 54 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(enlargement_sqft, 55 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(street_frontage, 56 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_no_of_stories, 57 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_no_of_stories, 58 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_height, 59 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_height, 60 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(existing_dwelling_units, 61 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(proposed_dwelling_units, 62 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(existing_occupancy, 63 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(proposed_occupancy, 64 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(site_fill, 65 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist1, 66 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist2, 67 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist3, 68 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_district1, 69 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_district2, 70 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_type, 71 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(non_profit, 72 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_first_name, 73 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_last_name, 74 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_business_name, 75 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_house_number, 76 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_house_street_name, 77 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 78 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 79 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zip, 80 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_phone, 81 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_description, 82 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dobrundate, 83 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_s1_no, 84 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_construction_floor_area, 85 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(withdrawal_flag, 86 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(signoff_date, 87 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_action_status, 88 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_action_date, 89 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(building_class, 90 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(job_no_good_count, 91 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(gis_latitude, 92 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(gis_longitude, 93 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(gis_council_district, 94 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_census_tract, 95 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_nta_name, 96 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_bin, 97 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(created_at, 98 + __off, 93, __dbStmt);
    return 98;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeLong(fact_id, 1 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(job_number, 2 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeInteger(doc_number, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(borough, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(house_number, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(street_name, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(block, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(lot, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeLong(bin_number, 9 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeString(job_type, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_status, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_status_descr, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(latest_action_date, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(building_type, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(community_board, 15 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(cluster, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(landmarked, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(adult_estab, 18 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(loft_board, 19 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city_owned, 20 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(little_e, 21 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pc_filed, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(efiling_filed, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(plumbing, 24 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(mechanical, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(boiler, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fuel_burning, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fuel_storage, 28 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(standpipe, 29 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sprinkler, 30 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fire_alarm, 31 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(equipment, 32 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fire_suppression, 33 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(curb_cut, 34 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(other, 35 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(other_description, 36 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_first_name, 37 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_last_name, 38 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_professional_title, 39 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(applicant_license, 40 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(professional_cert, 41 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pre_filing_date, 42 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(paid, 43 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fully_paid, 44 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(assigned, 45 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(approved, 46 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(fully_permitted, 47 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(initial_cost, 48 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_est_fee, 49 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(fee_status, 50 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_zoning_sqft, 51 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_zoning_sqft, 52 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(horizontal_enlrgmt, 53 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(vertical_enlrgmt, 54 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(enlargement_sqft, 55 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(street_frontage, 56 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_no_of_stories, 57 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_no_of_stories, 58 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(existing_height, 59 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(proposed_height, 60 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(existing_dwelling_units, 61 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(proposed_dwelling_units, 62 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(existing_occupancy, 63 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(proposed_occupancy, 64 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(site_fill, 65 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist1, 66 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist2, 67 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zoning_dist3, 68 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_district1, 69 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_district2, 70 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_type, 71 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(non_profit, 72 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_first_name, 73 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_last_name, 74 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_business_name, 75 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_house_number, 76 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_house_street_name, 77 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 78 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 79 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zip, 80 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(owner_phone, 81 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_description, 82 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dobrundate, 83 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(job_s1_no, 84 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_construction_floor_area, 85 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(withdrawal_flag, 86 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(signoff_date, 87 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_action_status, 88 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(special_action_date, 89 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(building_class, 90 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(job_no_good_count, 91 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(gis_latitude, 92 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(gis_longitude, 93 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(gis_council_district, 94 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_census_tract, 95 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_nta_name, 96 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(gis_bin, 97 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(created_at, 98 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.fact_id = null;
    } else {
    this.fact_id = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.job_number = null;
    } else {
    this.job_number = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.doc_number = null;
    } else {
    this.doc_number = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.borough = null;
    } else {
    this.borough = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.house_number = null;
    } else {
    this.house_number = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.street_name = null;
    } else {
    this.street_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.block = null;
    } else {
    this.block = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.lot = null;
    } else {
    this.lot = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.bin_number = null;
    } else {
    this.bin_number = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.job_type = null;
    } else {
    this.job_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.job_status = null;
    } else {
    this.job_status = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.job_status_descr = null;
    } else {
    this.job_status_descr = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.latest_action_date = null;
    } else {
    this.latest_action_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.building_type = null;
    } else {
    this.building_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.community_board = null;
    } else {
    this.community_board = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.cluster = null;
    } else {
    this.cluster = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.landmarked = null;
    } else {
    this.landmarked = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.adult_estab = null;
    } else {
    this.adult_estab = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.loft_board = null;
    } else {
    this.loft_board = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.city_owned = null;
    } else {
    this.city_owned = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.little_e = null;
    } else {
    this.little_e = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pc_filed = null;
    } else {
    this.pc_filed = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.efiling_filed = null;
    } else {
    this.efiling_filed = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.plumbing = null;
    } else {
    this.plumbing = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.mechanical = null;
    } else {
    this.mechanical = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.boiler = null;
    } else {
    this.boiler = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fuel_burning = null;
    } else {
    this.fuel_burning = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fuel_storage = null;
    } else {
    this.fuel_storage = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.standpipe = null;
    } else {
    this.standpipe = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.sprinkler = null;
    } else {
    this.sprinkler = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fire_alarm = null;
    } else {
    this.fire_alarm = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.equipment = null;
    } else {
    this.equipment = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fire_suppression = null;
    } else {
    this.fire_suppression = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.curb_cut = null;
    } else {
    this.curb_cut = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.other = null;
    } else {
    this.other = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.other_description = null;
    } else {
    this.other_description = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.applicant_first_name = null;
    } else {
    this.applicant_first_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.applicant_last_name = null;
    } else {
    this.applicant_last_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.applicant_professional_title = null;
    } else {
    this.applicant_professional_title = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.applicant_license = null;
    } else {
    this.applicant_license = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.professional_cert = null;
    } else {
    this.professional_cert = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pre_filing_date = null;
    } else {
    this.pre_filing_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.paid = null;
    } else {
    this.paid = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fully_paid = null;
    } else {
    this.fully_paid = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.assigned = null;
    } else {
    this.assigned = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.approved = null;
    } else {
    this.approved = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fully_permitted = null;
    } else {
    this.fully_permitted = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.initial_cost = null;
    } else {
    this.initial_cost = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.total_est_fee = null;
    } else {
    this.total_est_fee = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.fee_status = null;
    } else {
    this.fee_status = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.existing_zoning_sqft = null;
    } else {
    this.existing_zoning_sqft = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.proposed_zoning_sqft = null;
    } else {
    this.proposed_zoning_sqft = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.horizontal_enlrgmt = null;
    } else {
    this.horizontal_enlrgmt = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.vertical_enlrgmt = null;
    } else {
    this.vertical_enlrgmt = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.enlargement_sqft = null;
    } else {
    this.enlargement_sqft = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.street_frontage = null;
    } else {
    this.street_frontage = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.existing_no_of_stories = null;
    } else {
    this.existing_no_of_stories = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.proposed_no_of_stories = null;
    } else {
    this.proposed_no_of_stories = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.existing_height = null;
    } else {
    this.existing_height = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.proposed_height = null;
    } else {
    this.proposed_height = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.existing_dwelling_units = null;
    } else {
    this.existing_dwelling_units = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.proposed_dwelling_units = null;
    } else {
    this.proposed_dwelling_units = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.existing_occupancy = null;
    } else {
    this.existing_occupancy = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.proposed_occupancy = null;
    } else {
    this.proposed_occupancy = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.site_fill = null;
    } else {
    this.site_fill = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zoning_dist1 = null;
    } else {
    this.zoning_dist1 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zoning_dist2 = null;
    } else {
    this.zoning_dist2 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zoning_dist3 = null;
    } else {
    this.zoning_dist3 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.special_district1 = null;
    } else {
    this.special_district1 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.special_district2 = null;
    } else {
    this.special_district2 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_type = null;
    } else {
    this.owner_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.non_profit = null;
    } else {
    this.non_profit = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_first_name = null;
    } else {
    this.owner_first_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_last_name = null;
    } else {
    this.owner_last_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_business_name = null;
    } else {
    this.owner_business_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_house_number = null;
    } else {
    this.owner_house_number = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_house_street_name = null;
    } else {
    this.owner_house_street_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.city = null;
    } else {
    this.city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.state = null;
    } else {
    this.state = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zip = null;
    } else {
    this.zip = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.owner_phone = null;
    } else {
    this.owner_phone = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.job_description = null;
    } else {
    this.job_description = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dobrundate = null;
    } else {
    this.dobrundate = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.job_s1_no = null;
    } else {
    this.job_s1_no = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.total_construction_floor_area = null;
    } else {
    this.total_construction_floor_area = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.withdrawal_flag = null;
    } else {
    this.withdrawal_flag = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.signoff_date = null;
    } else {
    this.signoff_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.special_action_status = null;
    } else {
    this.special_action_status = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.special_action_date = null;
    } else {
    this.special_action_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.building_class = null;
    } else {
    this.building_class = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.job_no_good_count = null;
    } else {
    this.job_no_good_count = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.gis_latitude = null;
    } else {
    this.gis_latitude = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.gis_longitude = null;
    } else {
    this.gis_longitude = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.gis_council_district = null;
    } else {
    this.gis_council_district = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.gis_census_tract = null;
    } else {
    this.gis_census_tract = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.gis_nta_name = null;
    } else {
    this.gis_nta_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.gis_bin = null;
    } else {
    this.gis_bin = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.created_at = null;
    } else {
    this.created_at = new Timestamp(__dataIn.readLong());
    this.created_at.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.fact_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.fact_id);
    }
    if (null == this.job_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.job_number);
    }
    if (null == this.doc_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.doc_number);
    }
    if (null == this.borough) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, borough);
    }
    if (null == this.house_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, house_number);
    }
    if (null == this.street_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, street_name);
    }
    if (null == this.block) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.block);
    }
    if (null == this.lot) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.lot);
    }
    if (null == this.bin_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.bin_number);
    }
    if (null == this.job_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_type);
    }
    if (null == this.job_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_status);
    }
    if (null == this.job_status_descr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_status_descr);
    }
    if (null == this.latest_action_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, latest_action_date);
    }
    if (null == this.building_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, building_type);
    }
    if (null == this.community_board) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, community_board);
    }
    if (null == this.cluster) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, cluster);
    }
    if (null == this.landmarked) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, landmarked);
    }
    if (null == this.adult_estab) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, adult_estab);
    }
    if (null == this.loft_board) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, loft_board);
    }
    if (null == this.city_owned) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city_owned);
    }
    if (null == this.little_e) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, little_e);
    }
    if (null == this.pc_filed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pc_filed);
    }
    if (null == this.efiling_filed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, efiling_filed);
    }
    if (null == this.plumbing) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, plumbing);
    }
    if (null == this.mechanical) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, mechanical);
    }
    if (null == this.boiler) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, boiler);
    }
    if (null == this.fuel_burning) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fuel_burning);
    }
    if (null == this.fuel_storage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fuel_storage);
    }
    if (null == this.standpipe) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, standpipe);
    }
    if (null == this.sprinkler) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sprinkler);
    }
    if (null == this.fire_alarm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fire_alarm);
    }
    if (null == this.equipment) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, equipment);
    }
    if (null == this.fire_suppression) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fire_suppression);
    }
    if (null == this.curb_cut) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, curb_cut);
    }
    if (null == this.other) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, other);
    }
    if (null == this.other_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, other_description);
    }
    if (null == this.applicant_first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_first_name);
    }
    if (null == this.applicant_last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_last_name);
    }
    if (null == this.applicant_professional_title) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_professional_title);
    }
    if (null == this.applicant_license) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_license);
    }
    if (null == this.professional_cert) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, professional_cert);
    }
    if (null == this.pre_filing_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pre_filing_date);
    }
    if (null == this.paid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, paid);
    }
    if (null == this.fully_paid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fully_paid);
    }
    if (null == this.assigned) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, assigned);
    }
    if (null == this.approved) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, approved);
    }
    if (null == this.fully_permitted) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fully_permitted);
    }
    if (null == this.initial_cost) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.initial_cost, __dataOut);
    }
    if (null == this.total_est_fee) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_est_fee, __dataOut);
    }
    if (null == this.fee_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fee_status);
    }
    if (null == this.existing_zoning_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_zoning_sqft, __dataOut);
    }
    if (null == this.proposed_zoning_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_zoning_sqft, __dataOut);
    }
    if (null == this.horizontal_enlrgmt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, horizontal_enlrgmt);
    }
    if (null == this.vertical_enlrgmt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, vertical_enlrgmt);
    }
    if (null == this.enlargement_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.enlargement_sqft, __dataOut);
    }
    if (null == this.street_frontage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.street_frontage, __dataOut);
    }
    if (null == this.existing_no_of_stories) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_no_of_stories, __dataOut);
    }
    if (null == this.proposed_no_of_stories) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_no_of_stories, __dataOut);
    }
    if (null == this.existing_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_height, __dataOut);
    }
    if (null == this.proposed_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_height, __dataOut);
    }
    if (null == this.existing_dwelling_units) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.existing_dwelling_units);
    }
    if (null == this.proposed_dwelling_units) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.proposed_dwelling_units);
    }
    if (null == this.existing_occupancy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, existing_occupancy);
    }
    if (null == this.proposed_occupancy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, proposed_occupancy);
    }
    if (null == this.site_fill) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, site_fill);
    }
    if (null == this.zoning_dist1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist1);
    }
    if (null == this.zoning_dist2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist2);
    }
    if (null == this.zoning_dist3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist3);
    }
    if (null == this.special_district1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_district1);
    }
    if (null == this.special_district2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_district2);
    }
    if (null == this.owner_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_type);
    }
    if (null == this.non_profit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, non_profit);
    }
    if (null == this.owner_first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_first_name);
    }
    if (null == this.owner_last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_last_name);
    }
    if (null == this.owner_business_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_business_name);
    }
    if (null == this.owner_house_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_house_number);
    }
    if (null == this.owner_house_street_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_house_street_name);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.zip) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zip);
    }
    if (null == this.owner_phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_phone);
    }
    if (null == this.job_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_description);
    }
    if (null == this.dobrundate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dobrundate);
    }
    if (null == this.job_s1_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_s1_no);
    }
    if (null == this.total_construction_floor_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_construction_floor_area, __dataOut);
    }
    if (null == this.withdrawal_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, withdrawal_flag);
    }
    if (null == this.signoff_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, signoff_date);
    }
    if (null == this.special_action_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_action_status);
    }
    if (null == this.special_action_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_action_date);
    }
    if (null == this.building_class) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, building_class);
    }
    if (null == this.job_no_good_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.job_no_good_count);
    }
    if (null == this.gis_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.gis_latitude);
    }
    if (null == this.gis_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.gis_longitude);
    }
    if (null == this.gis_council_district) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_council_district);
    }
    if (null == this.gis_census_tract) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_census_tract);
    }
    if (null == this.gis_nta_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_nta_name);
    }
    if (null == this.gis_bin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_bin);
    }
    if (null == this.created_at) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.created_at.getTime());
    __dataOut.writeInt(this.created_at.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.fact_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.fact_id);
    }
    if (null == this.job_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.job_number);
    }
    if (null == this.doc_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.doc_number);
    }
    if (null == this.borough) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, borough);
    }
    if (null == this.house_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, house_number);
    }
    if (null == this.street_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, street_name);
    }
    if (null == this.block) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.block);
    }
    if (null == this.lot) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.lot);
    }
    if (null == this.bin_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.bin_number);
    }
    if (null == this.job_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_type);
    }
    if (null == this.job_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_status);
    }
    if (null == this.job_status_descr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_status_descr);
    }
    if (null == this.latest_action_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, latest_action_date);
    }
    if (null == this.building_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, building_type);
    }
    if (null == this.community_board) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, community_board);
    }
    if (null == this.cluster) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, cluster);
    }
    if (null == this.landmarked) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, landmarked);
    }
    if (null == this.adult_estab) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, adult_estab);
    }
    if (null == this.loft_board) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, loft_board);
    }
    if (null == this.city_owned) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city_owned);
    }
    if (null == this.little_e) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, little_e);
    }
    if (null == this.pc_filed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pc_filed);
    }
    if (null == this.efiling_filed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, efiling_filed);
    }
    if (null == this.plumbing) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, plumbing);
    }
    if (null == this.mechanical) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, mechanical);
    }
    if (null == this.boiler) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, boiler);
    }
    if (null == this.fuel_burning) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fuel_burning);
    }
    if (null == this.fuel_storage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fuel_storage);
    }
    if (null == this.standpipe) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, standpipe);
    }
    if (null == this.sprinkler) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sprinkler);
    }
    if (null == this.fire_alarm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fire_alarm);
    }
    if (null == this.equipment) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, equipment);
    }
    if (null == this.fire_suppression) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fire_suppression);
    }
    if (null == this.curb_cut) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, curb_cut);
    }
    if (null == this.other) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, other);
    }
    if (null == this.other_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, other_description);
    }
    if (null == this.applicant_first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_first_name);
    }
    if (null == this.applicant_last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_last_name);
    }
    if (null == this.applicant_professional_title) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_professional_title);
    }
    if (null == this.applicant_license) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, applicant_license);
    }
    if (null == this.professional_cert) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, professional_cert);
    }
    if (null == this.pre_filing_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pre_filing_date);
    }
    if (null == this.paid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, paid);
    }
    if (null == this.fully_paid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fully_paid);
    }
    if (null == this.assigned) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, assigned);
    }
    if (null == this.approved) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, approved);
    }
    if (null == this.fully_permitted) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fully_permitted);
    }
    if (null == this.initial_cost) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.initial_cost, __dataOut);
    }
    if (null == this.total_est_fee) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_est_fee, __dataOut);
    }
    if (null == this.fee_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, fee_status);
    }
    if (null == this.existing_zoning_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_zoning_sqft, __dataOut);
    }
    if (null == this.proposed_zoning_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_zoning_sqft, __dataOut);
    }
    if (null == this.horizontal_enlrgmt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, horizontal_enlrgmt);
    }
    if (null == this.vertical_enlrgmt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, vertical_enlrgmt);
    }
    if (null == this.enlargement_sqft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.enlargement_sqft, __dataOut);
    }
    if (null == this.street_frontage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.street_frontage, __dataOut);
    }
    if (null == this.existing_no_of_stories) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_no_of_stories, __dataOut);
    }
    if (null == this.proposed_no_of_stories) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_no_of_stories, __dataOut);
    }
    if (null == this.existing_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.existing_height, __dataOut);
    }
    if (null == this.proposed_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.proposed_height, __dataOut);
    }
    if (null == this.existing_dwelling_units) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.existing_dwelling_units);
    }
    if (null == this.proposed_dwelling_units) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.proposed_dwelling_units);
    }
    if (null == this.existing_occupancy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, existing_occupancy);
    }
    if (null == this.proposed_occupancy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, proposed_occupancy);
    }
    if (null == this.site_fill) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, site_fill);
    }
    if (null == this.zoning_dist1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist1);
    }
    if (null == this.zoning_dist2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist2);
    }
    if (null == this.zoning_dist3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zoning_dist3);
    }
    if (null == this.special_district1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_district1);
    }
    if (null == this.special_district2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_district2);
    }
    if (null == this.owner_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_type);
    }
    if (null == this.non_profit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, non_profit);
    }
    if (null == this.owner_first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_first_name);
    }
    if (null == this.owner_last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_last_name);
    }
    if (null == this.owner_business_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_business_name);
    }
    if (null == this.owner_house_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_house_number);
    }
    if (null == this.owner_house_street_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_house_street_name);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.zip) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zip);
    }
    if (null == this.owner_phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, owner_phone);
    }
    if (null == this.job_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_description);
    }
    if (null == this.dobrundate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dobrundate);
    }
    if (null == this.job_s1_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, job_s1_no);
    }
    if (null == this.total_construction_floor_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_construction_floor_area, __dataOut);
    }
    if (null == this.withdrawal_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, withdrawal_flag);
    }
    if (null == this.signoff_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, signoff_date);
    }
    if (null == this.special_action_status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_action_status);
    }
    if (null == this.special_action_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, special_action_date);
    }
    if (null == this.building_class) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, building_class);
    }
    if (null == this.job_no_good_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.job_no_good_count);
    }
    if (null == this.gis_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.gis_latitude);
    }
    if (null == this.gis_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.gis_longitude);
    }
    if (null == this.gis_council_district) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_council_district);
    }
    if (null == this.gis_census_tract) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_census_tract);
    }
    if (null == this.gis_nta_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_nta_name);
    }
    if (null == this.gis_bin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, gis_bin);
    }
    if (null == this.created_at) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.created_at.getTime());
    __dataOut.writeInt(this.created_at.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(fact_id==null?"null":"" + fact_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_number==null?"null":"" + job_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(doc_number==null?"null":"" + doc_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(borough==null?"null":borough, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(house_number==null?"null":house_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_name==null?"null":street_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(block==null?"null":"" + block, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lot==null?"null":"" + lot, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bin_number==null?"null":"" + bin_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_type==null?"null":job_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_status==null?"null":job_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_status_descr==null?"null":job_status_descr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latest_action_date==null?"null":latest_action_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_type==null?"null":building_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(community_board==null?"null":community_board, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cluster==null?"null":cluster, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(landmarked==null?"null":landmarked, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(adult_estab==null?"null":adult_estab, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(loft_board==null?"null":loft_board, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city_owned==null?"null":city_owned, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(little_e==null?"null":little_e, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pc_filed==null?"null":pc_filed, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(efiling_filed==null?"null":efiling_filed, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(plumbing==null?"null":plumbing, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mechanical==null?"null":mechanical, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(boiler==null?"null":boiler, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fuel_burning==null?"null":fuel_burning, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fuel_storage==null?"null":fuel_storage, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(standpipe==null?"null":standpipe, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sprinkler==null?"null":sprinkler, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fire_alarm==null?"null":fire_alarm, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(equipment==null?"null":equipment, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fire_suppression==null?"null":fire_suppression, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(curb_cut==null?"null":curb_cut, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(other==null?"null":other, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(other_description==null?"null":other_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_first_name==null?"null":applicant_first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_last_name==null?"null":applicant_last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_professional_title==null?"null":applicant_professional_title, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_license==null?"null":applicant_license, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(professional_cert==null?"null":professional_cert, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pre_filing_date==null?"null":pre_filing_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(paid==null?"null":paid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fully_paid==null?"null":fully_paid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(assigned==null?"null":assigned, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(approved==null?"null":approved, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fully_permitted==null?"null":fully_permitted, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(initial_cost==null?"null":initial_cost.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_est_fee==null?"null":total_est_fee.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fee_status==null?"null":fee_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_zoning_sqft==null?"null":existing_zoning_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_zoning_sqft==null?"null":proposed_zoning_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(horizontal_enlrgmt==null?"null":horizontal_enlrgmt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vertical_enlrgmt==null?"null":vertical_enlrgmt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(enlargement_sqft==null?"null":enlargement_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_frontage==null?"null":street_frontage.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_no_of_stories==null?"null":existing_no_of_stories.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_no_of_stories==null?"null":proposed_no_of_stories.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_height==null?"null":existing_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_height==null?"null":proposed_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_dwelling_units==null?"null":"" + existing_dwelling_units, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_dwelling_units==null?"null":"" + proposed_dwelling_units, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_occupancy==null?"null":existing_occupancy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_occupancy==null?"null":proposed_occupancy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(site_fill==null?"null":site_fill, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist1==null?"null":zoning_dist1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist2==null?"null":zoning_dist2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist3==null?"null":zoning_dist3, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_district1==null?"null":special_district1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_district2==null?"null":special_district2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_type==null?"null":owner_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(non_profit==null?"null":non_profit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_first_name==null?"null":owner_first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_last_name==null?"null":owner_last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_business_name==null?"null":owner_business_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_house_number==null?"null":owner_house_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_house_street_name==null?"null":owner_house_street_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zip==null?"null":zip, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_phone==null?"null":owner_phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_description==null?"null":job_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dobrundate==null?"null":dobrundate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_s1_no==null?"null":job_s1_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_construction_floor_area==null?"null":total_construction_floor_area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(withdrawal_flag==null?"null":withdrawal_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(signoff_date==null?"null":signoff_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_action_status==null?"null":special_action_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_action_date==null?"null":special_action_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_class==null?"null":building_class, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_no_good_count==null?"null":"" + job_no_good_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_latitude==null?"null":"" + gis_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_longitude==null?"null":"" + gis_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_council_district==null?"null":gis_council_district, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_census_tract==null?"null":gis_census_tract, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_nta_name==null?"null":gis_nta_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_bin==null?"null":gis_bin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(created_at==null?"null":"" + created_at, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(fact_id==null?"null":"" + fact_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_number==null?"null":"" + job_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(doc_number==null?"null":"" + doc_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(borough==null?"null":borough, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(house_number==null?"null":house_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_name==null?"null":street_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(block==null?"null":"" + block, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lot==null?"null":"" + lot, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bin_number==null?"null":"" + bin_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_type==null?"null":job_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_status==null?"null":job_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_status_descr==null?"null":job_status_descr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latest_action_date==null?"null":latest_action_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_type==null?"null":building_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(community_board==null?"null":community_board, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cluster==null?"null":cluster, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(landmarked==null?"null":landmarked, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(adult_estab==null?"null":adult_estab, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(loft_board==null?"null":loft_board, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city_owned==null?"null":city_owned, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(little_e==null?"null":little_e, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pc_filed==null?"null":pc_filed, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(efiling_filed==null?"null":efiling_filed, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(plumbing==null?"null":plumbing, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mechanical==null?"null":mechanical, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(boiler==null?"null":boiler, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fuel_burning==null?"null":fuel_burning, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fuel_storage==null?"null":fuel_storage, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(standpipe==null?"null":standpipe, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sprinkler==null?"null":sprinkler, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fire_alarm==null?"null":fire_alarm, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(equipment==null?"null":equipment, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fire_suppression==null?"null":fire_suppression, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(curb_cut==null?"null":curb_cut, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(other==null?"null":other, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(other_description==null?"null":other_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_first_name==null?"null":applicant_first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_last_name==null?"null":applicant_last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_professional_title==null?"null":applicant_professional_title, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(applicant_license==null?"null":applicant_license, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(professional_cert==null?"null":professional_cert, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pre_filing_date==null?"null":pre_filing_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(paid==null?"null":paid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fully_paid==null?"null":fully_paid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(assigned==null?"null":assigned, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(approved==null?"null":approved, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fully_permitted==null?"null":fully_permitted, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(initial_cost==null?"null":initial_cost.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_est_fee==null?"null":total_est_fee.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fee_status==null?"null":fee_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_zoning_sqft==null?"null":existing_zoning_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_zoning_sqft==null?"null":proposed_zoning_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(horizontal_enlrgmt==null?"null":horizontal_enlrgmt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vertical_enlrgmt==null?"null":vertical_enlrgmt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(enlargement_sqft==null?"null":enlargement_sqft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_frontage==null?"null":street_frontage.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_no_of_stories==null?"null":existing_no_of_stories.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_no_of_stories==null?"null":proposed_no_of_stories.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_height==null?"null":existing_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_height==null?"null":proposed_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_dwelling_units==null?"null":"" + existing_dwelling_units, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_dwelling_units==null?"null":"" + proposed_dwelling_units, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(existing_occupancy==null?"null":existing_occupancy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(proposed_occupancy==null?"null":proposed_occupancy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(site_fill==null?"null":site_fill, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist1==null?"null":zoning_dist1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist2==null?"null":zoning_dist2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zoning_dist3==null?"null":zoning_dist3, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_district1==null?"null":special_district1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_district2==null?"null":special_district2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_type==null?"null":owner_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(non_profit==null?"null":non_profit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_first_name==null?"null":owner_first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_last_name==null?"null":owner_last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_business_name==null?"null":owner_business_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_house_number==null?"null":owner_house_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_house_street_name==null?"null":owner_house_street_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zip==null?"null":zip, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(owner_phone==null?"null":owner_phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_description==null?"null":job_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dobrundate==null?"null":dobrundate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_s1_no==null?"null":job_s1_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_construction_floor_area==null?"null":total_construction_floor_area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(withdrawal_flag==null?"null":withdrawal_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(signoff_date==null?"null":signoff_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_action_status==null?"null":special_action_status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(special_action_date==null?"null":special_action_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_class==null?"null":building_class, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(job_no_good_count==null?"null":"" + job_no_good_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_latitude==null?"null":"" + gis_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_longitude==null?"null":"" + gis_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_council_district==null?"null":gis_council_district, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_census_tract==null?"null":gis_census_tract, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_nta_name==null?"null":gis_nta_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(gis_bin==null?"null":gis_bin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(created_at==null?"null":"" + created_at, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fact_id = null; } else {
      this.fact_id = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.job_number = null; } else {
      this.job_number = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.doc_number = null; } else {
      this.doc_number = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.borough = null; } else {
      this.borough = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.house_number = null; } else {
      this.house_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.street_name = null; } else {
      this.street_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.block = null; } else {
      this.block = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lot = null; } else {
      this.lot = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bin_number = null; } else {
      this.bin_number = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_type = null; } else {
      this.job_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_status = null; } else {
      this.job_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_status_descr = null; } else {
      this.job_status_descr = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.latest_action_date = null; } else {
      this.latest_action_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.building_type = null; } else {
      this.building_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.community_board = null; } else {
      this.community_board = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.cluster = null; } else {
      this.cluster = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.landmarked = null; } else {
      this.landmarked = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.adult_estab = null; } else {
      this.adult_estab = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.loft_board = null; } else {
      this.loft_board = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city_owned = null; } else {
      this.city_owned = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.little_e = null; } else {
      this.little_e = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pc_filed = null; } else {
      this.pc_filed = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.efiling_filed = null; } else {
      this.efiling_filed = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.plumbing = null; } else {
      this.plumbing = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.mechanical = null; } else {
      this.mechanical = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.boiler = null; } else {
      this.boiler = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fuel_burning = null; } else {
      this.fuel_burning = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fuel_storage = null; } else {
      this.fuel_storage = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.standpipe = null; } else {
      this.standpipe = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sprinkler = null; } else {
      this.sprinkler = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fire_alarm = null; } else {
      this.fire_alarm = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.equipment = null; } else {
      this.equipment = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fire_suppression = null; } else {
      this.fire_suppression = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.curb_cut = null; } else {
      this.curb_cut = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.other = null; } else {
      this.other = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.other_description = null; } else {
      this.other_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_first_name = null; } else {
      this.applicant_first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_last_name = null; } else {
      this.applicant_last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_professional_title = null; } else {
      this.applicant_professional_title = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_license = null; } else {
      this.applicant_license = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.professional_cert = null; } else {
      this.professional_cert = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pre_filing_date = null; } else {
      this.pre_filing_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.paid = null; } else {
      this.paid = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fully_paid = null; } else {
      this.fully_paid = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.assigned = null; } else {
      this.assigned = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.approved = null; } else {
      this.approved = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fully_permitted = null; } else {
      this.fully_permitted = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.initial_cost = null; } else {
      this.initial_cost = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_est_fee = null; } else {
      this.total_est_fee = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fee_status = null; } else {
      this.fee_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_zoning_sqft = null; } else {
      this.existing_zoning_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_zoning_sqft = null; } else {
      this.proposed_zoning_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.horizontal_enlrgmt = null; } else {
      this.horizontal_enlrgmt = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.vertical_enlrgmt = null; } else {
      this.vertical_enlrgmt = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.enlargement_sqft = null; } else {
      this.enlargement_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.street_frontage = null; } else {
      this.street_frontage = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_no_of_stories = null; } else {
      this.existing_no_of_stories = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_no_of_stories = null; } else {
      this.proposed_no_of_stories = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_height = null; } else {
      this.existing_height = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_height = null; } else {
      this.proposed_height = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_dwelling_units = null; } else {
      this.existing_dwelling_units = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_dwelling_units = null; } else {
      this.proposed_dwelling_units = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.existing_occupancy = null; } else {
      this.existing_occupancy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.proposed_occupancy = null; } else {
      this.proposed_occupancy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.site_fill = null; } else {
      this.site_fill = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist1 = null; } else {
      this.zoning_dist1 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist2 = null; } else {
      this.zoning_dist2 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist3 = null; } else {
      this.zoning_dist3 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_district1 = null; } else {
      this.special_district1 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_district2 = null; } else {
      this.special_district2 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_type = null; } else {
      this.owner_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.non_profit = null; } else {
      this.non_profit = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_first_name = null; } else {
      this.owner_first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_last_name = null; } else {
      this.owner_last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_business_name = null; } else {
      this.owner_business_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_house_number = null; } else {
      this.owner_house_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_house_street_name = null; } else {
      this.owner_house_street_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zip = null; } else {
      this.zip = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_phone = null; } else {
      this.owner_phone = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_description = null; } else {
      this.job_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dobrundate = null; } else {
      this.dobrundate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_s1_no = null; } else {
      this.job_s1_no = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_construction_floor_area = null; } else {
      this.total_construction_floor_area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.withdrawal_flag = null; } else {
      this.withdrawal_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.signoff_date = null; } else {
      this.signoff_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_action_status = null; } else {
      this.special_action_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_action_date = null; } else {
      this.special_action_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.building_class = null; } else {
      this.building_class = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.job_no_good_count = null; } else {
      this.job_no_good_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gis_latitude = null; } else {
      this.gis_latitude = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gis_longitude = null; } else {
      this.gis_longitude = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_council_district = null; } else {
      this.gis_council_district = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_census_tract = null; } else {
      this.gis_census_tract = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_nta_name = null; } else {
      this.gis_nta_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_bin = null; } else {
      this.gis_bin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.created_at = null; } else {
      this.created_at = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fact_id = null; } else {
      this.fact_id = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.job_number = null; } else {
      this.job_number = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.doc_number = null; } else {
      this.doc_number = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.borough = null; } else {
      this.borough = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.house_number = null; } else {
      this.house_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.street_name = null; } else {
      this.street_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.block = null; } else {
      this.block = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lot = null; } else {
      this.lot = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bin_number = null; } else {
      this.bin_number = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_type = null; } else {
      this.job_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_status = null; } else {
      this.job_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_status_descr = null; } else {
      this.job_status_descr = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.latest_action_date = null; } else {
      this.latest_action_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.building_type = null; } else {
      this.building_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.community_board = null; } else {
      this.community_board = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.cluster = null; } else {
      this.cluster = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.landmarked = null; } else {
      this.landmarked = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.adult_estab = null; } else {
      this.adult_estab = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.loft_board = null; } else {
      this.loft_board = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city_owned = null; } else {
      this.city_owned = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.little_e = null; } else {
      this.little_e = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pc_filed = null; } else {
      this.pc_filed = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.efiling_filed = null; } else {
      this.efiling_filed = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.plumbing = null; } else {
      this.plumbing = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.mechanical = null; } else {
      this.mechanical = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.boiler = null; } else {
      this.boiler = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fuel_burning = null; } else {
      this.fuel_burning = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fuel_storage = null; } else {
      this.fuel_storage = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.standpipe = null; } else {
      this.standpipe = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sprinkler = null; } else {
      this.sprinkler = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fire_alarm = null; } else {
      this.fire_alarm = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.equipment = null; } else {
      this.equipment = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fire_suppression = null; } else {
      this.fire_suppression = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.curb_cut = null; } else {
      this.curb_cut = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.other = null; } else {
      this.other = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.other_description = null; } else {
      this.other_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_first_name = null; } else {
      this.applicant_first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_last_name = null; } else {
      this.applicant_last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_professional_title = null; } else {
      this.applicant_professional_title = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.applicant_license = null; } else {
      this.applicant_license = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.professional_cert = null; } else {
      this.professional_cert = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pre_filing_date = null; } else {
      this.pre_filing_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.paid = null; } else {
      this.paid = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fully_paid = null; } else {
      this.fully_paid = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.assigned = null; } else {
      this.assigned = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.approved = null; } else {
      this.approved = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fully_permitted = null; } else {
      this.fully_permitted = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.initial_cost = null; } else {
      this.initial_cost = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_est_fee = null; } else {
      this.total_est_fee = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.fee_status = null; } else {
      this.fee_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_zoning_sqft = null; } else {
      this.existing_zoning_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_zoning_sqft = null; } else {
      this.proposed_zoning_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.horizontal_enlrgmt = null; } else {
      this.horizontal_enlrgmt = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.vertical_enlrgmt = null; } else {
      this.vertical_enlrgmt = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.enlargement_sqft = null; } else {
      this.enlargement_sqft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.street_frontage = null; } else {
      this.street_frontage = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_no_of_stories = null; } else {
      this.existing_no_of_stories = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_no_of_stories = null; } else {
      this.proposed_no_of_stories = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_height = null; } else {
      this.existing_height = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_height = null; } else {
      this.proposed_height = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.existing_dwelling_units = null; } else {
      this.existing_dwelling_units = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.proposed_dwelling_units = null; } else {
      this.proposed_dwelling_units = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.existing_occupancy = null; } else {
      this.existing_occupancy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.proposed_occupancy = null; } else {
      this.proposed_occupancy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.site_fill = null; } else {
      this.site_fill = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist1 = null; } else {
      this.zoning_dist1 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist2 = null; } else {
      this.zoning_dist2 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zoning_dist3 = null; } else {
      this.zoning_dist3 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_district1 = null; } else {
      this.special_district1 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_district2 = null; } else {
      this.special_district2 = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_type = null; } else {
      this.owner_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.non_profit = null; } else {
      this.non_profit = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_first_name = null; } else {
      this.owner_first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_last_name = null; } else {
      this.owner_last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_business_name = null; } else {
      this.owner_business_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_house_number = null; } else {
      this.owner_house_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_house_street_name = null; } else {
      this.owner_house_street_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zip = null; } else {
      this.zip = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.owner_phone = null; } else {
      this.owner_phone = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_description = null; } else {
      this.job_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dobrundate = null; } else {
      this.dobrundate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.job_s1_no = null; } else {
      this.job_s1_no = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_construction_floor_area = null; } else {
      this.total_construction_floor_area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.withdrawal_flag = null; } else {
      this.withdrawal_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.signoff_date = null; } else {
      this.signoff_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_action_status = null; } else {
      this.special_action_status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.special_action_date = null; } else {
      this.special_action_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.building_class = null; } else {
      this.building_class = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.job_no_good_count = null; } else {
      this.job_no_good_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gis_latitude = null; } else {
      this.gis_latitude = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.gis_longitude = null; } else {
      this.gis_longitude = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_council_district = null; } else {
      this.gis_council_district = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_census_tract = null; } else {
      this.gis_census_tract = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_nta_name = null; } else {
      this.gis_nta_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.gis_bin = null; } else {
      this.gis_bin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.created_at = null; } else {
      this.created_at = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    fact_job_applications o = (fact_job_applications) super.clone();
    o.created_at = (o.created_at != null) ? (java.sql.Timestamp) o.created_at.clone() : null;
    return o;
  }

  public void clone0(fact_job_applications o) throws CloneNotSupportedException {
    o.created_at = (o.created_at != null) ? (java.sql.Timestamp) o.created_at.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("fact_id", this.fact_id);
    __sqoop$field_map.put("job_number", this.job_number);
    __sqoop$field_map.put("doc_number", this.doc_number);
    __sqoop$field_map.put("borough", this.borough);
    __sqoop$field_map.put("house_number", this.house_number);
    __sqoop$field_map.put("street_name", this.street_name);
    __sqoop$field_map.put("block", this.block);
    __sqoop$field_map.put("lot", this.lot);
    __sqoop$field_map.put("bin_number", this.bin_number);
    __sqoop$field_map.put("job_type", this.job_type);
    __sqoop$field_map.put("job_status", this.job_status);
    __sqoop$field_map.put("job_status_descr", this.job_status_descr);
    __sqoop$field_map.put("latest_action_date", this.latest_action_date);
    __sqoop$field_map.put("building_type", this.building_type);
    __sqoop$field_map.put("community_board", this.community_board);
    __sqoop$field_map.put("cluster", this.cluster);
    __sqoop$field_map.put("landmarked", this.landmarked);
    __sqoop$field_map.put("adult_estab", this.adult_estab);
    __sqoop$field_map.put("loft_board", this.loft_board);
    __sqoop$field_map.put("city_owned", this.city_owned);
    __sqoop$field_map.put("little_e", this.little_e);
    __sqoop$field_map.put("pc_filed", this.pc_filed);
    __sqoop$field_map.put("efiling_filed", this.efiling_filed);
    __sqoop$field_map.put("plumbing", this.plumbing);
    __sqoop$field_map.put("mechanical", this.mechanical);
    __sqoop$field_map.put("boiler", this.boiler);
    __sqoop$field_map.put("fuel_burning", this.fuel_burning);
    __sqoop$field_map.put("fuel_storage", this.fuel_storage);
    __sqoop$field_map.put("standpipe", this.standpipe);
    __sqoop$field_map.put("sprinkler", this.sprinkler);
    __sqoop$field_map.put("fire_alarm", this.fire_alarm);
    __sqoop$field_map.put("equipment", this.equipment);
    __sqoop$field_map.put("fire_suppression", this.fire_suppression);
    __sqoop$field_map.put("curb_cut", this.curb_cut);
    __sqoop$field_map.put("other", this.other);
    __sqoop$field_map.put("other_description", this.other_description);
    __sqoop$field_map.put("applicant_first_name", this.applicant_first_name);
    __sqoop$field_map.put("applicant_last_name", this.applicant_last_name);
    __sqoop$field_map.put("applicant_professional_title", this.applicant_professional_title);
    __sqoop$field_map.put("applicant_license", this.applicant_license);
    __sqoop$field_map.put("professional_cert", this.professional_cert);
    __sqoop$field_map.put("pre_filing_date", this.pre_filing_date);
    __sqoop$field_map.put("paid", this.paid);
    __sqoop$field_map.put("fully_paid", this.fully_paid);
    __sqoop$field_map.put("assigned", this.assigned);
    __sqoop$field_map.put("approved", this.approved);
    __sqoop$field_map.put("fully_permitted", this.fully_permitted);
    __sqoop$field_map.put("initial_cost", this.initial_cost);
    __sqoop$field_map.put("total_est_fee", this.total_est_fee);
    __sqoop$field_map.put("fee_status", this.fee_status);
    __sqoop$field_map.put("existing_zoning_sqft", this.existing_zoning_sqft);
    __sqoop$field_map.put("proposed_zoning_sqft", this.proposed_zoning_sqft);
    __sqoop$field_map.put("horizontal_enlrgmt", this.horizontal_enlrgmt);
    __sqoop$field_map.put("vertical_enlrgmt", this.vertical_enlrgmt);
    __sqoop$field_map.put("enlargement_sqft", this.enlargement_sqft);
    __sqoop$field_map.put("street_frontage", this.street_frontage);
    __sqoop$field_map.put("existing_no_of_stories", this.existing_no_of_stories);
    __sqoop$field_map.put("proposed_no_of_stories", this.proposed_no_of_stories);
    __sqoop$field_map.put("existing_height", this.existing_height);
    __sqoop$field_map.put("proposed_height", this.proposed_height);
    __sqoop$field_map.put("existing_dwelling_units", this.existing_dwelling_units);
    __sqoop$field_map.put("proposed_dwelling_units", this.proposed_dwelling_units);
    __sqoop$field_map.put("existing_occupancy", this.existing_occupancy);
    __sqoop$field_map.put("proposed_occupancy", this.proposed_occupancy);
    __sqoop$field_map.put("site_fill", this.site_fill);
    __sqoop$field_map.put("zoning_dist1", this.zoning_dist1);
    __sqoop$field_map.put("zoning_dist2", this.zoning_dist2);
    __sqoop$field_map.put("zoning_dist3", this.zoning_dist3);
    __sqoop$field_map.put("special_district1", this.special_district1);
    __sqoop$field_map.put("special_district2", this.special_district2);
    __sqoop$field_map.put("owner_type", this.owner_type);
    __sqoop$field_map.put("non_profit", this.non_profit);
    __sqoop$field_map.put("owner_first_name", this.owner_first_name);
    __sqoop$field_map.put("owner_last_name", this.owner_last_name);
    __sqoop$field_map.put("owner_business_name", this.owner_business_name);
    __sqoop$field_map.put("owner_house_number", this.owner_house_number);
    __sqoop$field_map.put("owner_house_street_name", this.owner_house_street_name);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("zip", this.zip);
    __sqoop$field_map.put("owner_phone", this.owner_phone);
    __sqoop$field_map.put("job_description", this.job_description);
    __sqoop$field_map.put("dobrundate", this.dobrundate);
    __sqoop$field_map.put("job_s1_no", this.job_s1_no);
    __sqoop$field_map.put("total_construction_floor_area", this.total_construction_floor_area);
    __sqoop$field_map.put("withdrawal_flag", this.withdrawal_flag);
    __sqoop$field_map.put("signoff_date", this.signoff_date);
    __sqoop$field_map.put("special_action_status", this.special_action_status);
    __sqoop$field_map.put("special_action_date", this.special_action_date);
    __sqoop$field_map.put("building_class", this.building_class);
    __sqoop$field_map.put("job_no_good_count", this.job_no_good_count);
    __sqoop$field_map.put("gis_latitude", this.gis_latitude);
    __sqoop$field_map.put("gis_longitude", this.gis_longitude);
    __sqoop$field_map.put("gis_council_district", this.gis_council_district);
    __sqoop$field_map.put("gis_census_tract", this.gis_census_tract);
    __sqoop$field_map.put("gis_nta_name", this.gis_nta_name);
    __sqoop$field_map.put("gis_bin", this.gis_bin);
    __sqoop$field_map.put("created_at", this.created_at);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("fact_id", this.fact_id);
    __sqoop$field_map.put("job_number", this.job_number);
    __sqoop$field_map.put("doc_number", this.doc_number);
    __sqoop$field_map.put("borough", this.borough);
    __sqoop$field_map.put("house_number", this.house_number);
    __sqoop$field_map.put("street_name", this.street_name);
    __sqoop$field_map.put("block", this.block);
    __sqoop$field_map.put("lot", this.lot);
    __sqoop$field_map.put("bin_number", this.bin_number);
    __sqoop$field_map.put("job_type", this.job_type);
    __sqoop$field_map.put("job_status", this.job_status);
    __sqoop$field_map.put("job_status_descr", this.job_status_descr);
    __sqoop$field_map.put("latest_action_date", this.latest_action_date);
    __sqoop$field_map.put("building_type", this.building_type);
    __sqoop$field_map.put("community_board", this.community_board);
    __sqoop$field_map.put("cluster", this.cluster);
    __sqoop$field_map.put("landmarked", this.landmarked);
    __sqoop$field_map.put("adult_estab", this.adult_estab);
    __sqoop$field_map.put("loft_board", this.loft_board);
    __sqoop$field_map.put("city_owned", this.city_owned);
    __sqoop$field_map.put("little_e", this.little_e);
    __sqoop$field_map.put("pc_filed", this.pc_filed);
    __sqoop$field_map.put("efiling_filed", this.efiling_filed);
    __sqoop$field_map.put("plumbing", this.plumbing);
    __sqoop$field_map.put("mechanical", this.mechanical);
    __sqoop$field_map.put("boiler", this.boiler);
    __sqoop$field_map.put("fuel_burning", this.fuel_burning);
    __sqoop$field_map.put("fuel_storage", this.fuel_storage);
    __sqoop$field_map.put("standpipe", this.standpipe);
    __sqoop$field_map.put("sprinkler", this.sprinkler);
    __sqoop$field_map.put("fire_alarm", this.fire_alarm);
    __sqoop$field_map.put("equipment", this.equipment);
    __sqoop$field_map.put("fire_suppression", this.fire_suppression);
    __sqoop$field_map.put("curb_cut", this.curb_cut);
    __sqoop$field_map.put("other", this.other);
    __sqoop$field_map.put("other_description", this.other_description);
    __sqoop$field_map.put("applicant_first_name", this.applicant_first_name);
    __sqoop$field_map.put("applicant_last_name", this.applicant_last_name);
    __sqoop$field_map.put("applicant_professional_title", this.applicant_professional_title);
    __sqoop$field_map.put("applicant_license", this.applicant_license);
    __sqoop$field_map.put("professional_cert", this.professional_cert);
    __sqoop$field_map.put("pre_filing_date", this.pre_filing_date);
    __sqoop$field_map.put("paid", this.paid);
    __sqoop$field_map.put("fully_paid", this.fully_paid);
    __sqoop$field_map.put("assigned", this.assigned);
    __sqoop$field_map.put("approved", this.approved);
    __sqoop$field_map.put("fully_permitted", this.fully_permitted);
    __sqoop$field_map.put("initial_cost", this.initial_cost);
    __sqoop$field_map.put("total_est_fee", this.total_est_fee);
    __sqoop$field_map.put("fee_status", this.fee_status);
    __sqoop$field_map.put("existing_zoning_sqft", this.existing_zoning_sqft);
    __sqoop$field_map.put("proposed_zoning_sqft", this.proposed_zoning_sqft);
    __sqoop$field_map.put("horizontal_enlrgmt", this.horizontal_enlrgmt);
    __sqoop$field_map.put("vertical_enlrgmt", this.vertical_enlrgmt);
    __sqoop$field_map.put("enlargement_sqft", this.enlargement_sqft);
    __sqoop$field_map.put("street_frontage", this.street_frontage);
    __sqoop$field_map.put("existing_no_of_stories", this.existing_no_of_stories);
    __sqoop$field_map.put("proposed_no_of_stories", this.proposed_no_of_stories);
    __sqoop$field_map.put("existing_height", this.existing_height);
    __sqoop$field_map.put("proposed_height", this.proposed_height);
    __sqoop$field_map.put("existing_dwelling_units", this.existing_dwelling_units);
    __sqoop$field_map.put("proposed_dwelling_units", this.proposed_dwelling_units);
    __sqoop$field_map.put("existing_occupancy", this.existing_occupancy);
    __sqoop$field_map.put("proposed_occupancy", this.proposed_occupancy);
    __sqoop$field_map.put("site_fill", this.site_fill);
    __sqoop$field_map.put("zoning_dist1", this.zoning_dist1);
    __sqoop$field_map.put("zoning_dist2", this.zoning_dist2);
    __sqoop$field_map.put("zoning_dist3", this.zoning_dist3);
    __sqoop$field_map.put("special_district1", this.special_district1);
    __sqoop$field_map.put("special_district2", this.special_district2);
    __sqoop$field_map.put("owner_type", this.owner_type);
    __sqoop$field_map.put("non_profit", this.non_profit);
    __sqoop$field_map.put("owner_first_name", this.owner_first_name);
    __sqoop$field_map.put("owner_last_name", this.owner_last_name);
    __sqoop$field_map.put("owner_business_name", this.owner_business_name);
    __sqoop$field_map.put("owner_house_number", this.owner_house_number);
    __sqoop$field_map.put("owner_house_street_name", this.owner_house_street_name);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("zip", this.zip);
    __sqoop$field_map.put("owner_phone", this.owner_phone);
    __sqoop$field_map.put("job_description", this.job_description);
    __sqoop$field_map.put("dobrundate", this.dobrundate);
    __sqoop$field_map.put("job_s1_no", this.job_s1_no);
    __sqoop$field_map.put("total_construction_floor_area", this.total_construction_floor_area);
    __sqoop$field_map.put("withdrawal_flag", this.withdrawal_flag);
    __sqoop$field_map.put("signoff_date", this.signoff_date);
    __sqoop$field_map.put("special_action_status", this.special_action_status);
    __sqoop$field_map.put("special_action_date", this.special_action_date);
    __sqoop$field_map.put("building_class", this.building_class);
    __sqoop$field_map.put("job_no_good_count", this.job_no_good_count);
    __sqoop$field_map.put("gis_latitude", this.gis_latitude);
    __sqoop$field_map.put("gis_longitude", this.gis_longitude);
    __sqoop$field_map.put("gis_council_district", this.gis_council_district);
    __sqoop$field_map.put("gis_census_tract", this.gis_census_tract);
    __sqoop$field_map.put("gis_nta_name", this.gis_nta_name);
    __sqoop$field_map.put("gis_bin", this.gis_bin);
    __sqoop$field_map.put("created_at", this.created_at);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
