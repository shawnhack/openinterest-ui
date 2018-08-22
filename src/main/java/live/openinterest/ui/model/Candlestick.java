package live.openinterest.ui.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "date", "open", "high", "low", "close" })
public class Candlestick {

	private float open;
	private float low;
	private float high;
	private float close;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime date;

	/**
	 * @param amount
	 */
	public void update(float amount) {
		if (open == 0) {
			open = amount;
		}
		if (low == 0) {
			low = amount;
		}
		if (amount > high) {
			high = amount;
		}
		if (amount < low) {
			low = amount;
		}
		close = amount;
	}

	/**
	 * @return the open
	 */
	public float getOpen() {
		return open;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param other
	 * @return
	 */
	public boolean isSameDay(LocalDateTime timestamp) {
		if (date != null && timestamp != null) {
			return date.toLocalDate().equals(timestamp.toLocalDate());
		}
		return false;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(float open) {
		this.open = open;
	}

	/**
	 * @return the low
	 */
	public float getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(float low) {
		this.low = low;
	}

	/**
	 * @return the high
	 */
	public float getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(float high) {
		this.high = high;
	}

	/**
	 * @return the close
	 */
	public float getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(float close) {
		this.close = close;
	}

}
