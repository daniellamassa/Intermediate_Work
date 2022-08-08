"""
:author Dani Massa

I affirm that I have carried out the attached academic endeavors with full academic honesty, in accordance with
the Union College Honor Code and the course syllabus.
"""

DEFAULT_DISCOUNT_RATE = 0.10
MAXIMUM_DISCOUNT_RATE = 0.70


class Tool:

    def __init__(self, name, base_price):
        """
        constructor: initializes tool object properties.
        :param name: name of the tool, as a string, like "hammer".
        :param base_price: the tool's price when it's not on sale, as a float.
        """
        self.__name = name
        self.__base_price = base_price
        self.__discount_rate = DEFAULT_DISCOUNT_RATE
        self.__sale_status = False

    def put_on_sale(self):
        """
        make this item be on sale.
        """
        self.__sale_status = True

    def name(self):
        """
        :return: the name of this tool.
        """
        return self.__name

    def change_discount(self, new_rate):
        """
        change the discount rate for this tool. Do nothing if the new rate exceeds 70%.
        :param new_rate: new discount rate. cannot be higher than the maximum allowed discount of 70%.
        """
        if 0 < new_rate < MAXIMUM_DISCOUNT_RATE:
            self.__discount_rate = new_rate

    def take_off_sale(self):
        """
        make this item be regular price.
        """
        self.__sale_status = False

    def discount(self):
        """
        :return: the current discount rate for this tool.
        """
        return self.__discount_rate

    def is_on_sale(self):
        """
        :return: return True if this tool is on sale. Else return False.
        """
        return self.__sale_status

    def base_price(self):
        """
        :return: return the price of this tool when not on sale.
        """
        return self.__base_price

    def discounted_price(self):
        """
        :return: the price of this tool when on sale.
        """
        reduced_value = self.__discount_rate * self.__base_price
        discounted_price = self.__base_price - reduced_value
        return discounted_price

    def __printable_price(self, price):
        """
        private helper function: returns a given price in a format string to two decimal places
        :param price: any float value
        :return: formal string of $ and float value to two decimal places
        """
        printable_price = "${:.2f}".format(price)
        return printable_price

    def __str__(self):
        """
        :return: tool object as a printable string
        """
        name_print = "Tool Name: " + self.name() + "\n"
        base_price = self.base_price()
        base_price_print = "Base Price: " + self.__printable_price(base_price) + "\n"
        if self.is_on_sale():
            price = self.discounted_price()
            on_sale_print = "On Sale: Yes \n" + "Current Price: " + self.__printable_price(price) + "\n"
        else:
            price = self.base_price()
            on_sale_print = "On Sale: No \n" + "Current Price: " + self.__printable_price(price) + "\n"

        return name_print + base_price_print + on_sale_print
